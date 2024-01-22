package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ae\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u001d¢\u0006\u0002\b\u001f¢\u0006\u0002\b H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001ak\u0010#\u001a\u00020\u00132\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0003¢\u0006\u0002\u0010-\u001a\u0001\u0010.\u001a\u00020\u0013*\u00020\u001e2\u0006\u0010/\u001a\u00020*2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130%2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020*2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H\u0007¢\u0006\u0002\u00106\u001a;\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001aS\u0010B\u001a\u000208*\u0002092\u0006\u0010C\u001a\u00020;2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarItemVerticalPadding", "getNavigationBarItemVerticalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemBaselineLayout", "indicatorRipple", "Lkotlin/Function0;", "indicator", "icon", "label", "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationBar.kt */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    /* access modifiers changed from: private */
    public static final float IndicatorHorizontalPadding = Dp.m5986constructorimpl(Dp.m5986constructorimpl(NavigationBarTokens.INSTANCE.m2519getActiveIndicatorWidthD9Ej5fM() - NavigationBarTokens.INSTANCE.m2522getIconSizeD9Ej5fM()) / ((float) 2));
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = Dp.m5986constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final float IndicatorVerticalPadding = Dp.m5986constructorimpl(Dp.m5986constructorimpl(NavigationBarTokens.INSTANCE.m2518getActiveIndicatorHeightD9Ej5fM() - NavigationBarTokens.INSTANCE.m2522getIconSizeD9Ej5fM()) / ((float) 2));
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    /* access modifiers changed from: private */
    public static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m2521getContainerHeightD9Ej5fM();
    private static final float NavigationBarItemHorizontalPadding = Dp.m5986constructorimpl((float) 8);
    private static final float NavigationBarItemVerticalPadding = Dp.m5986constructorimpl((float) 16);

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00df  */
    /* renamed from: NavigationBar-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1991NavigationBarHsRjFd4(androidx.compose.ui.Modifier r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r11 = r33
            r12 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1596802123(0x5f2d444b, float:1.2485187E19)
            r1 = r34
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationBar)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,5)100@4715L14,101@4771L11,103@4929L12,106@4996L503:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r35
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r26
            goto L_0x0035
        L_0x0022:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r26
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r26
        L_0x0035:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r36 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r27
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r27
        L_0x004a:
            r6 = 16
        L_0x004c:
            r1 = r1 | r6
            goto L_0x0050
        L_0x004e:
            r4 = r27
        L_0x0050:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0069
            r6 = r36 & 4
            if (r6 != 0) goto L_0x0063
            r6 = r29
            boolean r8 = r10.changed((long) r6)
            if (r8 == 0) goto L_0x0065
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r6 = r29
        L_0x0065:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r8
            goto L_0x006b
        L_0x0069:
            r6 = r29
        L_0x006b:
            r8 = r36 & 8
            if (r8 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r31
            goto L_0x0089
        L_0x0074:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0087
            r9 = r31
            boolean r13 = r10.changed((float) r9)
            if (r13 == 0) goto L_0x0083
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r13
            goto L_0x0089
        L_0x0087:
            r9 = r31
        L_0x0089:
            r13 = 57344(0xe000, float:8.0356E-41)
            r14 = r12 & r13
            if (r14 != 0) goto L_0x00a5
            r14 = r36 & 16
            if (r14 != 0) goto L_0x009f
            r14 = r32
            boolean r15 = r10.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00a1
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r14 = r32
        L_0x00a1:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r15
            goto L_0x00a7
        L_0x00a5:
            r14 = r32
        L_0x00a7:
            r15 = r36 & 32
            if (r15 == 0) goto L_0x00af
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00ad:
            r1 = r1 | r15
            goto L_0x00c0
        L_0x00af:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00c0
            boolean r15 = r10.changed((java.lang.Object) r11)
            if (r15 == 0) goto L_0x00bd
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00bd:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ad
        L_0x00c0:
            r15 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r15 & r1
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r13) goto L_0x00df
            boolean r13 = r10.getSkipping()
            if (r13 != 0) goto L_0x00d0
            goto L_0x00df
        L_0x00d0:
            r10.skipToGroupEnd()
            r20 = r1
            r13 = r3
            r16 = r6
            r18 = r9
            r19 = r14
            r14 = r4
            goto L_0x01a8
        L_0x00df:
            r10.startDefaults()
            r13 = r12 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r13 == 0) goto L_0x010a
            boolean r13 = r10.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00f0
            goto L_0x010a
        L_0x00f0:
            r10.skipToGroupEnd()
            r2 = r36 & 2
            if (r2 == 0) goto L_0x00f9
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f9:
            r2 = r36 & 4
            if (r2 == 0) goto L_0x00ff
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ff:
            r2 = r36 & 16
            if (r2 == 0) goto L_0x0104
            r1 = r1 & r15
        L_0x0104:
            r2 = r3
            r3 = r4
            r5 = r6
            r7 = r9
            r8 = r14
            goto L_0x014a
        L_0x010a:
            if (r2 == 0) goto L_0x0111
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0112
        L_0x0111:
            r2 = r3
        L_0x0112:
            r3 = r36 & 2
            r13 = 6
            if (r3 == 0) goto L_0x0120
            androidx.compose.material3.NavigationBarDefaults r3 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            long r3 = r3.getContainerColor(r10, r13)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0121
        L_0x0120:
            r3 = r4
        L_0x0121:
            r5 = r36 & 4
            if (r5 == 0) goto L_0x0132
            androidx.compose.material3.MaterialTheme r5 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r5 = r5.getColorScheme(r10, r13)
            long r5 = androidx.compose.material3.ColorSchemeKt.m1853contentColorFor4WTKRHQ(r5, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0133
        L_0x0132:
            r5 = r6
        L_0x0133:
            if (r8 == 0) goto L_0x013c
            androidx.compose.material3.NavigationBarDefaults r7 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            float r7 = r7.m1988getElevationD9Ej5fM()
            goto L_0x013d
        L_0x013c:
            r7 = r9
        L_0x013d:
            r8 = r36 & 16
            if (r8 == 0) goto L_0x0149
            androidx.compose.material3.NavigationBarDefaults r8 = androidx.compose.material3.NavigationBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r8 = r8.getWindowInsets(r10, r13)
            r1 = r1 & r15
            goto L_0x014a
        L_0x0149:
            r8 = r14
        L_0x014a:
            r10.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0159
            r9 = -1
            java.lang.String r13 = "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r9, r13)
        L_0x0159:
            r14 = 0
            r20 = 0
            r21 = 0
            androidx.compose.material3.NavigationBarKt$NavigationBar$1 r0 = new androidx.compose.material3.NavigationBarKt$NavigationBar$1
            r0.<init>(r8, r11, r1)
            r9 = 105663120(0x64c4a90, float:3.8422915E-35)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r9, r13, r0)
            r22 = r0
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            r0 = 12582912(0xc00000, float:1.7632415E-38)
            r9 = r1 & 14
            r0 = r0 | r9
            int r9 = r1 << 3
            r9 = r9 & 896(0x380, float:1.256E-42)
            r0 = r0 | r9
            int r9 = r1 << 3
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r9
            int r9 = r1 << 3
            r13 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r13
            r24 = r0 | r9
            r25 = 98
            r13 = r2
            r15 = r3
            r17 = r5
            r19 = r7
            r23 = r10
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x019e:
            r20 = r1
            r13 = r2
            r14 = r3
            r16 = r5
            r18 = r7
            r19 = r8
        L_0x01a8:
            androidx.compose.runtime.ScopeUpdateScope r9 = r10.endRestartGroup()
            if (r9 != 0) goto L_0x01b1
            r22 = r10
            goto L_0x01d0
        L_0x01b1:
            androidx.compose.material3.NavigationBarKt$NavigationBar$2 r21 = new androidx.compose.material3.NavigationBarKt$NavigationBar$2
            r0 = r21
            r1 = r13
            r2 = r14
            r4 = r16
            r6 = r18
            r7 = r19
            r8 = r33
            r11 = r9
            r9 = r35
            r22 = r10
            r10 = r36
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.m1991NavigationBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:159:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x05db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationBarItem(androidx.compose.foundation.layout.RowScope r48, boolean r49, kotlin.jvm.functions.Function0<kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.ui.Modifier r52, boolean r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, boolean r55, androidx.compose.material3.NavigationBarItemColors r56, androidx.compose.foundation.interaction.MutableInteractionSource r57, androidx.compose.runtime.Composer r58, int r59, int r60) {
        /*
            r13 = r48
            r14 = r49
            r15 = r50
            r12 = r51
            r11 = r59
            r10 = r60
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -663510974(0xffffffffd873a042, float:-1.07147851E15)
            r1 = r58
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationBarItem)P(8,7,3,6,2,5)167@7728L8,168@7788L39,189@8723L30,202@9101L52,191@8759L2501:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r59
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r10
            if (r2 == 0) goto L_0x0035
            r1 = r1 | 6
            goto L_0x0043
        L_0x0035:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0043
            boolean r2 = r9.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0041
            r2 = 4
            goto L_0x0042
        L_0x0041:
            r2 = 2
        L_0x0042:
            r1 = r1 | r2
        L_0x0043:
            r2 = r10 & 1
            if (r2 == 0) goto L_0x004a
            r1 = r1 | 48
            goto L_0x005a
        L_0x004a:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x005a
            boolean r2 = r9.changed((boolean) r14)
            if (r2 == 0) goto L_0x0057
            r2 = 32
            goto L_0x0059
        L_0x0057:
            r2 = 16
        L_0x0059:
            r1 = r1 | r2
        L_0x005a:
            r2 = r10 & 2
            if (r2 == 0) goto L_0x0061
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0071
        L_0x0061:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0071
            boolean r2 = r9.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x006e
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r2
        L_0x0071:
            r2 = r10 & 4
            if (r2 == 0) goto L_0x0078
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0078:
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0088
            boolean r2 = r9.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0085
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r1 = r1 | r2
        L_0x0088:
            r2 = r10 & 8
            r5 = 57344(0xe000, float:8.0356E-41)
            if (r2 == 0) goto L_0x0094
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r6 = r52
            goto L_0x00a9
        L_0x0094:
            r6 = r11 & r5
            if (r6 != 0) goto L_0x00a7
            r6 = r52
            boolean r7 = r9.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x00a3
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r1 = r1 | r7
            goto L_0x00a9
        L_0x00a7:
            r6 = r52
        L_0x00a9:
            r7 = r10 & 16
            if (r7 == 0) goto L_0x00b3
            r8 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r8
            r8 = r53
            goto L_0x00ca
        L_0x00b3:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00c8
            r8 = r53
            boolean r16 = r9.changed((boolean) r8)
            if (r16 == 0) goto L_0x00c3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c5
        L_0x00c3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c5:
            r1 = r1 | r16
            goto L_0x00ca
        L_0x00c8:
            r8 = r53
        L_0x00ca:
            r16 = r10 & 32
            if (r16 == 0) goto L_0x00d5
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r5 = r54
            goto L_0x00ed
        L_0x00d5:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r11 & r17
            if (r17 != 0) goto L_0x00eb
            r5 = r54
            boolean r17 = r9.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x00e6
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e8
        L_0x00e6:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00e8:
            r1 = r1 | r17
            goto L_0x00ed
        L_0x00eb:
            r5 = r54
        L_0x00ed:
            r17 = r10 & 64
            if (r17 == 0) goto L_0x00f8
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r18
            r4 = r55
            goto L_0x0110
        L_0x00f8:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x010e
            r4 = r55
            boolean r18 = r9.changed((boolean) r4)
            if (r18 == 0) goto L_0x0109
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010b
        L_0x0109:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x010b:
            r1 = r1 | r18
            goto L_0x0110
        L_0x010e:
            r4 = r55
        L_0x0110:
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x012c
            r3 = r10 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x0125
            r3 = r56
            boolean r18 = r9.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x0127
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0129
        L_0x0125:
            r3 = r56
        L_0x0127:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0129:
            r1 = r1 | r18
            goto L_0x012e
        L_0x012c:
            r3 = r56
        L_0x012e:
            r0 = r10 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0139
            r18 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r18
            r3 = r57
            goto L_0x0151
        L_0x0139:
            r18 = 1879048192(0x70000000, float:1.58456325E29)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x014f
            r3 = r57
            boolean r18 = r9.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x014a
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014c
        L_0x014a:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014c:
            r1 = r1 | r18
            goto L_0x0151
        L_0x014f:
            r3 = r57
        L_0x0151:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r1 & r18
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r4) goto L_0x0173
            boolean r3 = r9.getSkipping()
            if (r3 != 0) goto L_0x0162
            goto L_0x0173
        L_0x0162:
            r9.skipToGroupEnd()
            r32 = r55
            r16 = r56
            r39 = r57
            r17 = r1
            r25 = r5
            r13 = r6
            r15 = r8
            goto L_0x05e6
        L_0x0173:
            r9.startDefaults()
            r3 = r11 & 1
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r33 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r3 == 0) goto L_0x0198
            boolean r3 = r9.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0187
            goto L_0x0198
        L_0x0187:
            r9.skipToGroupEnd()
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0190
            r1 = r1 & r33
        L_0x0190:
            r2 = r55
            r3 = r56
            r0 = r57
            goto L_0x0212
        L_0x0198:
            if (r2 == 0) goto L_0x019f
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r6 = r2
        L_0x019f:
            if (r7 == 0) goto L_0x01a3
            r2 = 1
            r8 = r2
        L_0x01a3:
            if (r16 == 0) goto L_0x01a7
            r2 = 0
            r5 = r2
        L_0x01a7:
            if (r17 == 0) goto L_0x01ab
            r2 = 1
            goto L_0x01ad
        L_0x01ab:
            r2 = r55
        L_0x01ad:
            r3 = r10 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x01ca
            androidx.compose.material3.NavigationBarItemDefaults r16 = androidx.compose.material3.NavigationBarItemDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r28 = 196608(0x30000, float:2.75506E-40)
            r29 = 31
            r27 = r9
            androidx.compose.material3.NavigationBarItemColors r3 = r16.m1990colorszjMxDiM(r17, r19, r21, r23, r25, r27, r28, r29)
            r1 = r1 & r33
            goto L_0x01cc
        L_0x01ca:
            r3 = r56
        L_0x01cc:
            if (r0 == 0) goto L_0x020e
            r0 = 0
            r7 = 0
            r9.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            r4 = 0
            r52 = r9
            r17 = 0
            r53 = r0
            java.lang.Object r0 = r52.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r54 = r1
            java.lang.Object r1 = r19.getEmpty()
            if (r0 != r1) goto L_0x01fd
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r55 = r0
            r0 = r52
            r0.updateRememberedValue(r1)
            goto L_0x0203
        L_0x01fd:
            r55 = r0
            r0 = r52
            r1 = r55
        L_0x0203:
            r9.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r1 = r54
            goto L_0x0212
        L_0x020e:
            r54 = r1
            r0 = r57
        L_0x0212:
            r9.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0224
            r4 = -1
            java.lang.String r7 = "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:159)"
            r10 = -663510974(0xffffffffd873a042, float:-1.07147851E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r1, r4, r7)
        L_0x0224:
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1 r4 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
            r52 = r4
            r53 = r3
            r54 = r49
            r55 = r1
            r56 = r5
            r57 = r2
            r58 = r51
            r52.<init>(r53, r54, r55, r56, r57, r58)
            r7 = -1419576100(0xffffffffab62fcdc, float:-8.064224E-13)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r7, r10, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            if (r5 == 0) goto L_0x025a
            r17 = r5
            r18 = 0
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1 r7 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1
            r7.<init>(r3, r14, r1, r5)
            r25 = r5
            r5 = 1644987592(0x620c84c8, float:6.48028E20)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r5, r10, r7)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r20 = r5
            goto L_0x025e
        L_0x025a:
            r25 = r5
            r20 = 0
        L_0x025e:
            r5 = 0
            r7 = r5
            r17 = 0
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r10)
            java.lang.String r10 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r10)
            r10 = 0
            r52 = r9
            r16 = 0
            java.lang.Object r5 = r52.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r53 = r7
            java.lang.Object r7 = r23.getEmpty()
            if (r5 != r7) goto L_0x029c
            r7 = 0
            r54 = r5
            r21 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)
            r55 = r7
            r56 = r10
            r7 = 2
            r10 = 0
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r10, r7, r10)
            r7 = r52
            r7.updateRememberedValue(r5)
            goto L_0x02a2
        L_0x029c:
            r7 = r52
            r54 = r5
            r56 = r10
        L_0x02a2:
            r9.endReplaceableGroup()
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            androidx.compose.ui.semantics.Role$Companion r7 = androidx.compose.ui.semantics.Role.Companion
            int r7 = r7.m5319getTabo7Vup1c()
            r10 = 0
            androidx.compose.ui.semantics.Role r7 = androidx.compose.ui.semantics.Role.m5306boximpl(r7)
            r52 = r6
            r53 = r49
            r54 = r0
            r55 = r10
            r56 = r8
            r57 = r7
            r58 = r50
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.selection.SelectableKt.m1079selectableO2vRcR0(r52, r53, r54, r55, r56, r57, r58)
            r10 = 1065353216(0x3f800000, float:1.0)
            r16 = 0
            r17 = 2
            r22 = 0
            r52 = r48
            r53 = r7
            r54 = r10
            r55 = r16
            r56 = r17
            r57 = r22
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.RowScope.weight$default(r52, r53, r54, r55, r56, r57)
            r10 = 6
            r16 = r10
            r17 = 0
            r10 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r10)
            java.lang.String r10 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r10)
            boolean r10 = r9.changed((java.lang.Object) r5)
            r53 = r9
            r22 = 0
            r54 = r6
            java.lang.Object r6 = r53.rememberedValue()
            r23 = 0
            if (r10 != 0) goto L_0x0316
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r55 = r8
            java.lang.Object r8 = r24.getEmpty()
            if (r6 != r8) goto L_0x0311
            goto L_0x0318
        L_0x0311:
            r8 = r53
            r56 = r6
            goto L_0x0328
        L_0x0316:
            r55 = r8
        L_0x0318:
            r8 = 0
            r56 = r6
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1 r6 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1
            r6.<init>(r5)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r8 = r53
            r8.updateRememberedValue(r6)
        L_0x0328:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.layout.OnRemeasuredModifierKt.onSizeChanged(r7, r6)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getCenter()
            r8 = 48
            r10 = 0
            r53 = r10
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r10)
            java.lang.String r10 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r10)
            r10 = 0
            int r16 = r8 >> 3
            r16 = r16 & 14
            int r17 = r8 >> 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r11 = r16 | r17
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r10, r9, r11)
            int r16 = r8 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r26 = 0
            r56 = r7
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r17 = 6
            r22 = 0
            r57 = r10
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r12 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r10, r12)
            java.lang.Object r23 = r9.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r7 = r23
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r10 = r17
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r17 = 6
            r22 = 0
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r13, r12)
            java.lang.Object r13 = r9.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r10 = r13
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r17 = 6
            r22 = 0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r15, r12)
            java.lang.Object r15 = r9.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r13 = r15
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            r27 = r6
            int r6 = r16 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r22 = 6
            r6 = r6 | 6
            r28 = r17
            r29 = 0
            r32 = r2
            androidx.compose.runtime.Applier r2 = r9.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x03e7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03e7:
            r9.startReusableNode()
            boolean r2 = r9.getInserting()
            if (r2 == 0) goto L_0x03f4
            r9.createNode(r15)
            goto L_0x03f7
        L_0x03f4:
            r9.useNode()
        L_0x03f7:
            r9.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2787constructorimpl(r9)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
            r33 = r15
            kotlin.jvm.functions.Function2 r15 = r22.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r11, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r7, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r10, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r13, r15)
            r9.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r2)
            int r15 = r6 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r34 = r7
            r7 = r28
            r7.invoke(r2, r9, r15)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r2)
            int r2 = r6 >> 9
            r2 = r2 & 14
            r15 = r9
            r28 = 0
            r35 = r6
            r6 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r15.startReplaceableGroup(r6)
            java.lang.String r6 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            r6 = r2 & 11
            r36 = r2
            r2 = 2
            if (r6 != r2) goto L_0x0478
            boolean r2 = r15.getSkipping()
            if (r2 != 0) goto L_0x0469
            goto L_0x0478
        L_0x0469:
            r15.skipToGroupEnd()
            r39 = r0
            r58 = r5
            r47 = r7
            r52 = r8
            r30 = r10
            goto L_0x05c3
        L_0x0478:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r6 = r8 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            r17 = 6
            r6 = r6 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r44 = r15
            r45 = 0
            r46 = r2
            r2 = 1796243068(0x6b107e7c, float:1.7468262E26)
            r47 = r7
            r7 = r44
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "C207@9247L145,*216@9676L7,223@9976L120,248@10969L285:NavigationBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r6 & 81
            r44 = r6
            r6 = 16
            if (r2 != r6) goto L_0x04b5
            boolean r2 = r7.getSkipping()
            if (r2 != 0) goto L_0x04a8
            goto L_0x04b5
        L_0x04a8:
            r7.skipToGroupEnd()
            r39 = r0
            r58 = r5
            r52 = r8
            r30 = r10
            goto L_0x05bf
        L_0x04b5:
            if (r14 == 0) goto L_0x04ba
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x04bb
        L_0x04ba:
            r2 = 0
        L_0x04bb:
            r37 = r2
            r2 = 100
            r52 = r8
            r30 = r10
            r6 = 0
            r8 = 0
            r10 = 6
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r6, r8, r10, r8)
            r38 = r2
            androidx.compose.animation.core.AnimationSpec r38 = (androidx.compose.animation.core.AnimationSpec) r38
            r39 = 0
            r40 = 0
            r42 = 48
            r43 = 12
            r41 = r7
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r37, r38, r39, r40, r41, r42, r43)
            r21 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r8 = 0
            r10 = 0
            r17 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r8, r12)
            java.lang.Object r8 = r7.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r6 = r8
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            r8 = 0
            androidx.compose.material3.tokens.NavigationBarTokens r10 = androidx.compose.material3.tokens.NavigationBarTokens.INSTANCE
            float r10 = r10.m2519getActiveIndicatorWidthD9Ej5fM()
            int r10 = r6.m5961roundToPx0680j_4(r10)
            int r12 = m1992NavigationBarItem$lambda3(r5)
            int r12 = r12 - r10
            float r12 = (float) r12
            r58 = r5
            r5 = 2
            float r5 = (float) r5
            float r12 = r12 / r5
            float r5 = IndicatorVerticalOffset
            float r5 = r6.m5967toPx0680j_4(r5)
            r17 = r6
            long r5 = androidx.compose.ui.geometry.OffsetKt.Offset(r12, r5)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m2904boximpl(r5)
            int r10 = r1 >> 27
            r10 = r10 & 14
            r12 = 0
            r17 = r10
            r10 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r7.startReplaceableGroup(r10)
            java.lang.String r10 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r10)
            boolean r10 = r7.changed((java.lang.Object) r0)
            boolean r21 = r7.changed((java.lang.Object) r8)
            r10 = r10 | r21
            r21 = r7
            r22 = 0
            r23 = r8
            java.lang.Object r8 = r21.rememberedValue()
            r24 = 0
            if (r10 != 0) goto L_0x0560
            androidx.compose.runtime.Composer$Companion r31 = androidx.compose.runtime.Composer.Companion
            r37 = r10
            java.lang.Object r10 = r31.getEmpty()
            if (r8 != r10) goto L_0x0558
            goto L_0x0562
        L_0x0558:
            r39 = r0
            r0 = r8
            r31 = r0
            r8 = r21
            goto L_0x0579
        L_0x0560:
            r37 = r10
        L_0x0562:
            r10 = 0
            r31 = r8
            androidx.compose.material3.MappedInteractionSource r8 = new androidx.compose.material3.MappedInteractionSource
            r38 = r10
            r10 = r0
            androidx.compose.foundation.interaction.InteractionSource r10 = (androidx.compose.foundation.interaction.InteractionSource) r10
            r39 = r0
            r0 = 0
            r8.<init>(r10, r5, r0)
            r0 = r8
            r8 = r21
            r8.updateRememberedValue(r0)
        L_0x0579:
            r7.endReplaceableGroup()
            androidx.compose.material3.MappedInteractionSource r0 = (androidx.compose.material3.MappedInteractionSource) r0
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1 r8 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
            r8.<init>(r0)
            r10 = 691730997(0x293afa35, float:4.1517317E-14)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r10, r12, r8)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1 r10 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
            r10.<init>(r3, r2)
            r31 = r0
            r0 = -474426875(0xffffffffe3b8d205, float:-6.818669E21)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r0, r12, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            float r22 = m1994NavigationBarItem$lambda9$lambda6(r2)
            int r10 = r1 >> 9
            r12 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r12
            r10 = r10 | 438(0x1b6, float:6.14E-43)
            r17 = r8
            r18 = r0
            r19 = r4
            r21 = r32
            r23 = r7
            r24 = r10
            NavigationBarItemBaselineLayout(r17, r18, r19, r20, r21, r22, r23, r24)
        L_0x05bf:
            r7.endReplaceableGroup()
        L_0x05c3:
            r15.endReplaceableGroup()
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05de
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05de:
            r13 = r54
            r15 = r55
            r17 = r1
            r16 = r3
        L_0x05e6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r9.endRestartGroup()
            if (r12 != 0) goto L_0x05f1
            r19 = r9
            r52 = r13
            goto L_0x061a
        L_0x05f1:
            androidx.compose.material3.NavigationBarKt$NavigationBarItem$4 r18 = new androidx.compose.material3.NavigationBarKt$NavigationBarItem$4
            r0 = r18
            r1 = r48
            r2 = r49
            r3 = r50
            r4 = r51
            r5 = r13
            r6 = r15
            r7 = r25
            r8 = r32
            r19 = r9
            r9 = r16
            r10 = r39
            r11 = r59
            r52 = r13
            r13 = r12
            r12 = r60
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x061a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.NavigationBarItem(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationBarItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: NavigationBarItem$lambda-3  reason: not valid java name */
    private static final int m1992NavigationBarItem$lambda3(MutableState<Integer> $itemWidth$delegate) {
        return ((Number) $itemWidth$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationBarItem$lambda-4  reason: not valid java name */
    public static final void m1993NavigationBarItem$lambda4(MutableState<Integer> $itemWidth$delegate, int value) {
        $itemWidth$delegate.setValue(Integer.valueOf(value));
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationBarItem$lambda-9$lambda-6  reason: not valid java name */
    public static final float m1994NavigationBarItem$lambda9$lambda6(State<Float> $animationProgress$delegate) {
        return ((Number) $animationProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void NavigationBarItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> indicatorRipple, Function2<? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, float animationProgress, Composer $composer, int $changed) {
        Composer $composer2;
        Function2<? super Composer, ? super Integer, Unit> function2 = indicatorRipple;
        Function2<? super Composer, ? super Integer, Unit> function22 = indicator;
        Function2<? super Composer, ? super Integer, Unit> function23 = icon;
        Function2<? super Composer, ? super Integer, Unit> function24 = label;
        boolean z = alwaysShowLabel;
        float f = animationProgress;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(591111291);
        ComposerKt.sourceInformation($composer3, "C(NavigationBarItemBaselineLayout)P(4,3,2,5)389@16599L2465:NavigationBar.kt#uh7d8r");
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
            $dirty |= $composer3.changed((Object) function24) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer3.changed(z) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer3.changed(f) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(591111291, $dirty2, -1, "androidx.compose.material3.NavigationBarItemBaselineLayout (NavigationBar.kt:381)");
            }
            MeasurePolicy measurePolicy$iv = new NavigationBarKt$NavigationBarItemBaselineLayout$2(f, function24, z);
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.Companion;
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
            Modifier modifier = modifier$iv;
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            Composer $composer4 = $composer3;
            $composer4.startReplaceableGroup(1170727090);
            ComposerKt.sourceInformation($composer4, "C390@16616L17,395@16714L50,398@16807L260:NavigationBar.kt#uh7d8r");
            int i2 = $changed$iv$iv;
            if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                function2.invoke($composer4, Integer.valueOf($dirty2 & 14));
                $composer4.startReplaceableGroup(-311736667);
                ComposerKt.sourceInformation($composer4, "392@16683L11");
                if (f > 0.0f) {
                    function22.invoke($composer4, Integer.valueOf(($dirty2 >> 3) & 14));
                }
                $composer4.endReplaceableGroup();
                Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.Companion, IconLayoutIdTag);
                Density density = density$iv;
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                LayoutDirection layoutDirection = layoutDirection$iv;
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                ViewConfiguration viewConfiguration = viewConfiguration$iv;
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                Alignment alignment = contentAlignment$iv;
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                int i3 = $changed2;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier2 = modifier$iv2;
                int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = materializerOf2;
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
                    $composer5.startReplaceableGroup(-1237554120);
                    ComposerKt.sourceInformation($composer5, "C395@16756L6:NavigationBar.kt#uh7d8r");
                    int i5 = $changed3;
                    if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                        function23.invoke($composer5, Integer.valueOf(($dirty2 >> 6) & 14));
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
                if (function24 != null) {
                    Modifier modifier$iv3 = PaddingKt.m762paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.Companion, LabelLayoutIdTag), z ? 1.0f : animationProgress), Dp.m5986constructorimpl(NavigationBarItemHorizontalPadding / ((float) 2)), 0.0f, 2, (Object) null);
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    Alignment alignment2 = contentAlignment$iv2;
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
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume9 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv3);
                    Modifier modifier3 = modifier$iv3;
                    int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
                    Composer $composer$iv2 = $composer4;
                    int i6 = $changed$iv$iv$iv2;
                    $composer$iv2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                    if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                        int $changed4 = ((0 >> 6) & 112) | 6;
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                        Composer $composer6 = $composer$iv2;
                        $composer6.startReplaceableGroup(359627658);
                        ComposerKt.sourceInformation($composer6, "C403@17058L7:NavigationBar.kt#uh7d8r");
                        int i7 = $changed4;
                        if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                            function24.invoke($composer6, Integer.valueOf(($dirty2 >> 9) & 14));
                        } else {
                            $composer6.skipToGroupEnd();
                        }
                        $composer6.endReplaceableGroup();
                    } else {
                        $composer$iv2.skipToGroupEnd();
                        ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv2;
                    }
                    $composer$iv2.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    $composer4.endNode();
                    $composer4.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                }
            } else {
                $composer4.skipToGroupEnd();
                Density density3 = density$iv;
                LayoutDirection layoutDirection2 = layoutDirection$iv;
                ViewConfiguration viewConfiguration4 = viewConfiguration$iv;
                int i8 = $changed2;
                $composer2 = $composer3;
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
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i9 = $dirty2;
            return;
        }
        int i10 = $dirty2;
        endRestartGroup.updateScope(new NavigationBarKt$NavigationBarItemBaselineLayout$3(indicatorRipple, indicator, icon, label, alwaysShowLabel, animationProgress, $changed));
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4  reason: not valid java name */
    public static final MeasureResult m1999placeIconX9ElhV4(MeasureScope $this$placeIcon_u2dX9ElhV4, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints) {
        int width = Constraints.m5930getMaxWidthimpl(constraints);
        int height = Constraints.m5929getMaxHeightimpl(constraints);
        return MeasureScope.layout$default($this$placeIcon_u2dX9ElhV4, width, height, (Map) null, new NavigationBarKt$placeIcon$1(indicatorPlaceable, iconPlaceable, (width - iconPlaceable.getWidth()) / 2, (height - iconPlaceable.getHeight()) / 2, indicatorRipplePlaceable, (width - indicatorRipplePlaceable.getWidth()) / 2, (height - indicatorRipplePlaceable.getHeight()) / 2, width, height), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0  reason: not valid java name */
    public static final MeasureResult m2000placeLabelAndIconzUg2_y0(MeasureScope $this$placeLabelAndIcon_u2dzUg2_y0, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, boolean alwaysShowLabel, float animationProgress) {
        MeasureScope measureScope = $this$placeLabelAndIcon_u2dzUg2_y0;
        int height = Constraints.m5929getMaxHeightimpl(constraints);
        float f = NavigationBarItemVerticalPadding;
        int labelY = (height - labelPlaceable.getHeight()) - measureScope.m5961roundToPx0680j_4(f);
        int selectedIconY = measureScope.m5961roundToPx0680j_4(f);
        int iconDistance = (alwaysShowLabel ? selectedIconY : (height - iconPlaceable.getHeight()) / 2) - selectedIconY;
        int offset = MathKt.roundToInt(((float) iconDistance) * (((float) 1) - animationProgress));
        int containerWidth = Constraints.m5930getMaxWidthimpl(constraints);
        int i = iconDistance;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dzUg2_y0, containerWidth, height, (Map) null, new NavigationBarKt$placeLabelAndIcon$1(indicatorPlaceable, alwaysShowLabel, animationProgress, labelPlaceable, (containerWidth - labelPlaceable.getWidth()) / 2, labelY, offset, iconPlaceable, (containerWidth - iconPlaceable.getWidth()) / 2, selectedIconY, indicatorRipplePlaceable, (containerWidth - indicatorRipplePlaceable.getWidth()) / 2, selectedIconY - measureScope.m5961roundToPx0680j_4(IndicatorVerticalPadding), containerWidth, $this$placeLabelAndIcon_u2dzUg2_y0), 4, (Object) null);
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarItemVerticalPadding() {
        return NavigationBarItemVerticalPadding;
    }
}
