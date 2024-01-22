package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.unit.ConstraintsKt;
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

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2 \b\u0002\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\b\b\u0002\u0010/\u001a\u00020)2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00104\u001ak\u00105\u001a\u00020\u00172\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0003¢\u0006\u0002\u0010:\u001a;\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aS\u0010F\u001a\u00020<*\u00020=2\u0006\u0010G\u001a\u00020?2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020C2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\"\u0019\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u000f\"\u0019\u0010\u0014\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u000f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalPaddingNoLabel", "IndicatorVerticalPaddingWithLabel", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationRailHeaderPadding", "NavigationRailItemHeight", "getNavigationRailItemHeight", "()F", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailVerticalPadding", "getNavigationRailVerticalPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", "indicatorRipple", "indicator", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationRail.kt */
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    /* access modifiers changed from: private */
    public static final float IndicatorHorizontalPadding = Dp.m5986constructorimpl(Dp.m5986constructorimpl(NavigationRailTokens.INSTANCE.m2530getActiveIndicatorWidthD9Ej5fM() - NavigationRailTokens.INSTANCE.m2533getIconSizeD9Ej5fM()) / ((float) 2));
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    /* access modifiers changed from: private */
    public static final float IndicatorVerticalPaddingNoLabel = Dp.m5986constructorimpl(Dp.m5986constructorimpl(NavigationRailTokens.INSTANCE.m2535getNoLabelActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m2533getIconSizeD9Ej5fM()) / ((float) 2));
    /* access modifiers changed from: private */
    public static final float IndicatorVerticalPaddingWithLabel = Dp.m5986constructorimpl(Dp.m5986constructorimpl(NavigationRailTokens.INSTANCE.m2529getActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m2533getIconSizeD9Ej5fM()) / ((float) 2));
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    /* access modifiers changed from: private */
    public static final float NavigationRailHeaderPadding = Dp.m5986constructorimpl((float) 8);
    private static final float NavigationRailItemHeight = NavigationRailTokens.INSTANCE.m2535getNoLabelActiveIndicatorHeightD9Ej5fM();
    private static final float NavigationRailItemVerticalPadding = Dp.m5986constructorimpl((float) 4);
    private static final float NavigationRailItemWidth = NavigationRailTokens.INSTANCE.m2532getContainerWidthD9Ej5fM();
    private static final float NavigationRailVerticalPadding = Dp.m5986constructorimpl((float) 4);

    /* JADX WARNING: Removed duplicated region for block: B:111:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00de  */
    /* renamed from: NavigationRail-qi6gXK8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2018NavigationRailqi6gXK8(androidx.compose.ui.Modifier r26, long r27, long r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.foundation.layout.WindowInsets r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r11 = r33
            r12 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 118552648(0x710f848, float:1.0906319E-34)
            r1 = r34
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationRail)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,5)102@4774L14,103@4816L31,105@4963L12,108@5033L748:NavigationRail.kt#uh7d8r"
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
            boolean r13 = r10.changed((java.lang.Object) r9)
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
            r13 = r13 & r12
            if (r13 != 0) goto L_0x00a4
            r13 = r36 & 16
            if (r13 != 0) goto L_0x009e
            r13 = r32
            boolean r14 = r10.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00a0
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x009e:
            r13 = r32
        L_0x00a0:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r1 = r1 | r14
            goto L_0x00a6
        L_0x00a4:
            r13 = r32
        L_0x00a6:
            r14 = r36 & 32
            if (r14 == 0) goto L_0x00ae
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00ac:
            r1 = r1 | r14
            goto L_0x00bf
        L_0x00ae:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00bf
            boolean r14 = r10.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x00bc
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ac
        L_0x00bc:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ac
        L_0x00bf:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r1
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00de
            boolean r14 = r10.getSkipping()
            if (r14 != 0) goto L_0x00cf
            goto L_0x00de
        L_0x00cf:
            r10.skipToGroupEnd()
            r20 = r1
            r14 = r4
            r16 = r6
            r18 = r9
            r19 = r13
            r13 = r3
            goto L_0x0198
        L_0x00de:
            r10.startDefaults()
            r14 = r12 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r14 == 0) goto L_0x0109
            boolean r14 = r10.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00ef
            goto L_0x0109
        L_0x00ef:
            r10.skipToGroupEnd()
            r2 = r36 & 2
            if (r2 == 0) goto L_0x00f8
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f8:
            r2 = r36 & 4
            if (r2 == 0) goto L_0x00fe
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00fe:
            r2 = r36 & 16
            if (r2 == 0) goto L_0x0103
            r1 = r1 & r15
        L_0x0103:
            r2 = r3
            r3 = r4
            r5 = r6
            r7 = r9
            r8 = r13
            goto L_0x0142
        L_0x0109:
            if (r2 == 0) goto L_0x0110
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0111
        L_0x0110:
            r2 = r3
        L_0x0111:
            r3 = r36 & 2
            r14 = 6
            if (r3 == 0) goto L_0x011f
            androidx.compose.material3.NavigationRailDefaults r3 = androidx.compose.material3.NavigationRailDefaults.INSTANCE
            long r3 = r3.getContainerColor(r10, r14)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0120
        L_0x011f:
            r3 = r4
        L_0x0120:
            r5 = r36 & 4
            if (r5 == 0) goto L_0x012f
            int r5 = r1 >> 3
            r5 = r5 & 14
            long r5 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r3, r10, r5)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0130
        L_0x012f:
            r5 = r6
        L_0x0130:
            if (r8 == 0) goto L_0x0134
            r7 = 0
            goto L_0x0135
        L_0x0134:
            r7 = r9
        L_0x0135:
            r8 = r36 & 16
            if (r8 == 0) goto L_0x0141
            androidx.compose.material3.NavigationRailDefaults r8 = androidx.compose.material3.NavigationRailDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r8 = r8.getWindowInsets(r10, r14)
            r1 = r1 & r15
            goto L_0x0142
        L_0x0141:
            r8 = r13
        L_0x0142:
            r10.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0151
            r9 = -1
            java.lang.String r13 = "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r9, r13)
        L_0x0151:
            r14 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            androidx.compose.material3.NavigationRailKt$NavigationRail$1 r0 = new androidx.compose.material3.NavigationRailKt$NavigationRail$1
            r0.<init>(r8, r7, r1, r11)
            r9 = -2092683357(0xffffffff83442fa3, float:-5.7653907E-37)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r9, r13, r0)
            r22 = r0
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            r0 = r1 & 14
            r9 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r9
            int r9 = r1 << 3
            r9 = r9 & 896(0x380, float:1.256E-42)
            r0 = r0 | r9
            int r9 = r1 << 3
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r24 = r0 | r9
            r25 = 114(0x72, float:1.6E-43)
            r13 = r2
            r15 = r3
            r17 = r5
            r23 = r10
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x018e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x018e:
            r20 = r1
            r13 = r2
            r14 = r3
            r16 = r5
            r18 = r7
            r19 = r8
        L_0x0198:
            androidx.compose.runtime.ScopeUpdateScope r9 = r10.endRestartGroup()
            if (r9 != 0) goto L_0x01a1
            r22 = r10
            goto L_0x01c0
        L_0x01a1:
            androidx.compose.material3.NavigationRailKt$NavigationRail$2 r21 = new androidx.compose.material3.NavigationRailKt$NavigationRail$2
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
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.m2018NavigationRailqi6gXK8(androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:165:0x04ac  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationRailItem(boolean r50, kotlin.jvm.functions.Function0<kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.ui.Modifier r53, boolean r54, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, boolean r56, androidx.compose.material3.NavigationRailItemColors r57, androidx.compose.foundation.interaction.MutableInteractionSource r58, androidx.compose.runtime.Composer r59, int r60, int r61) {
        /*
            r12 = r50
            r13 = r51
            r14 = r52
            r15 = r60
            r11 = r61
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1533971045(0xffffffffa491759b, float:-6.308296E-17)
            r1 = r59
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationRailItem)P(8,7,3,6,2,5)168@7563L8,169@7623L39,190@8543L2637:NavigationRail.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r60
            r2 = r11 & 1
            if (r2 == 0) goto L_0x002d
            r1 = r1 | 6
            goto L_0x003b
        L_0x002d:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x003b
            boolean r2 = r10.changed((boolean) r12)
            if (r2 == 0) goto L_0x0039
            r2 = 4
            goto L_0x003a
        L_0x0039:
            r2 = 2
        L_0x003a:
            r1 = r1 | r2
        L_0x003b:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0042
            r1 = r1 | 48
            goto L_0x0052
        L_0x0042:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0052
            boolean r2 = r10.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x004f
            r2 = 32
            goto L_0x0051
        L_0x004f:
            r2 = 16
        L_0x0051:
            r1 = r1 | r2
        L_0x0052:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x0059
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0059:
            r2 = r15 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0069
            boolean r2 = r10.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0066
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r1 = r1 | r2
        L_0x0069:
            r2 = r11 & 8
            if (r2 == 0) goto L_0x0072
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r53
            goto L_0x0087
        L_0x0072:
            r5 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0085
            r5 = r53
            boolean r6 = r10.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0081
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r1 = r1 | r6
            goto L_0x0087
        L_0x0085:
            r5 = r53
        L_0x0087:
            r6 = r11 & 16
            r7 = 57344(0xe000, float:8.0356E-41)
            if (r6 == 0) goto L_0x0093
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r8 = r54
            goto L_0x00a8
        L_0x0093:
            r8 = r15 & r7
            if (r8 != 0) goto L_0x00a6
            r8 = r54
            boolean r9 = r10.changed((boolean) r8)
            if (r9 == 0) goto L_0x00a2
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r1 = r1 | r9
            goto L_0x00a8
        L_0x00a6:
            r8 = r54
        L_0x00a8:
            r9 = r11 & 32
            if (r9 == 0) goto L_0x00b3
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r7 = r55
            goto L_0x00cb
        L_0x00b3:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00c9
            r7 = r55
            boolean r16 = r10.changed((java.lang.Object) r7)
            if (r16 == 0) goto L_0x00c4
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c4:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r1 = r1 | r16
            goto L_0x00cb
        L_0x00c9:
            r7 = r55
        L_0x00cb:
            r16 = r11 & 64
            if (r16 == 0) goto L_0x00d6
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r4 = r56
            goto L_0x00ee
        L_0x00d6:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r15 & r17
            if (r17 != 0) goto L_0x00ec
            r4 = r56
            boolean r17 = r10.changed((boolean) r4)
            if (r17 == 0) goto L_0x00e7
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r1 = r1 | r17
            goto L_0x00ee
        L_0x00ec:
            r4 = r56
        L_0x00ee:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r15 & r17
            if (r17 != 0) goto L_0x010a
            r3 = r11 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x0103
            r3 = r57
            boolean r17 = r10.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x0105
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0103:
            r3 = r57
        L_0x0105:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r1 = r1 | r17
            goto L_0x010c
        L_0x010a:
            r3 = r57
        L_0x010c:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0117
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r17
            r3 = r58
            goto L_0x012f
        L_0x0117:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r15 & r17
            if (r17 != 0) goto L_0x012d
            r3 = r58
            boolean r17 = r10.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x0128
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012a
        L_0x0128:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012a:
            r1 = r1 | r17
            goto L_0x012f
        L_0x012d:
            r3 = r58
        L_0x012f:
            r17 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r1 & r17
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r4) goto L_0x0150
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L_0x0140
            goto L_0x0150
        L_0x0140:
            r10.skipToGroupEnd()
            r27 = r56
            r16 = r57
            r38 = r58
            r17 = r1
            r13 = r5
            r15 = r7
            r14 = r8
            goto L_0x0547
        L_0x0150:
            r10.startDefaults()
            r3 = r15 & 1
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r3 == 0) goto L_0x0171
            boolean r3 = r10.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0161
            goto L_0x0171
        L_0x0161:
            r10.skipToGroupEnd()
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0169
            r1 = r1 & r4
        L_0x0169:
            r2 = r56
            r3 = r57
            r0 = r58
            goto L_0x01e3
        L_0x0171:
            if (r2 == 0) goto L_0x0178
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = r2
        L_0x0178:
            if (r6 == 0) goto L_0x017c
            r2 = 1
            r8 = r2
        L_0x017c:
            if (r9 == 0) goto L_0x0180
            r2 = 0
            r7 = r2
        L_0x0180:
            if (r16 == 0) goto L_0x0184
            r2 = 1
            goto L_0x0186
        L_0x0184:
            r2 = r56
        L_0x0186:
            r3 = r11 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x01a2
            androidx.compose.material3.NavigationRailItemDefaults r16 = androidx.compose.material3.NavigationRailItemDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r28 = 196608(0x30000, float:2.75506E-40)
            r29 = 31
            r27 = r10
            androidx.compose.material3.NavigationRailItemColors r3 = r16.m2017colorszjMxDiM(r17, r19, r21, r23, r25, r27, r28, r29)
            r1 = r1 & r4
            goto L_0x01a4
        L_0x01a2:
            r3 = r57
        L_0x01a4:
            if (r0 == 0) goto L_0x01df
            r0 = 0
            r4 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r6)
            r6 = 0
            r9 = r10
            r16 = 0
            r53 = r0
            java.lang.Object r0 = r9.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r54 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x01d3
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r9.updateRememberedValue(r1)
            goto L_0x01d4
        L_0x01d3:
            r1 = r0
        L_0x01d4:
            r10.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r1 = r54
            goto L_0x01e3
        L_0x01df:
            r54 = r1
            r0 = r58
        L_0x01e3:
            r10.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x01f5
            r4 = -1
            java.lang.String r6 = "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:160)"
            r9 = -1533971045(0xffffffffa491759b, float:-6.308296E-17)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r1, r4, r6)
        L_0x01f5:
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1 r4 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
            r53 = r4
            r54 = r3
            r55 = r50
            r56 = r1
            r57 = r7
            r58 = r2
            r59 = r52
            r53.<init>(r54, r55, r56, r57, r58, r59)
            r6 = -1023357515(0xffffffffc300cdb5, float:-128.80354)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r6, r9, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            if (r7 == 0) goto L_0x0229
            r16 = r7
            r17 = 0
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1 r6 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1
            r6.<init>(r3, r12, r1, r7)
            r11 = -105269599(0xfffffffff9b9b6a1, float:-1.2053488E35)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r11, r9, r6)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r19 = r6
            goto L_0x022b
        L_0x0229:
            r19 = 0
        L_0x022b:
            androidx.compose.ui.semantics.Role$Companion r6 = androidx.compose.ui.semantics.Role.Companion
            int r6 = r6.m5319getTabo7Vup1c()
            r11 = 0
            androidx.compose.ui.semantics.Role r6 = androidx.compose.ui.semantics.Role.m5306boximpl(r6)
            r53 = r5
            r54 = r50
            r55 = r0
            r56 = r11
            r57 = r8
            r58 = r6
            r59 = r51
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.selection.SelectableKt.m1079selectableO2vRcR0(r53, r54, r55, r56, r57, r58, r59)
            float r11 = NavigationRailItemHeight
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m816height3ABfNKs(r6, r11)
            float r11 = NavigationRailItemWidth
            r9 = 0
            r54 = r5
            r55 = r8
            r5 = 0
            r8 = 2
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m837widthInVpY3zN4$default(r6, r11, r9, r8, r5)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenter()
            r8 = 48
            r24 = 0
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r10.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            r9 = 0
            int r16 = r8 >> 3
            r16 = r16 & 14
            int r17 = r8 >> 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r13 = r16 | r17
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r9, r10, r13)
            int r16 = r8 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r25 = r16
            r26 = 0
            r57 = r5
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r10.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r16 = 6
            r17 = 0
            r58 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r9, r14)
            java.lang.Object r20 = r10.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r5 = r20
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r9 = r16
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r16 = 6
            r17 = 0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r15, r14)
            java.lang.Object r15 = r10.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r9 = r15
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r16 = 6
            r17 = 0
            r27 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r14)
            java.lang.Object r2 = r10.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            r28 = r6
            int r6 = r25 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r29 = r4
            r4 = 6
            r6 = r6 | r4
            r32 = r16
            r33 = 0
            androidx.compose.runtime.Applier r4 = r10.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x0314
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0314:
            r10.startReusableNode()
            boolean r4 = r10.getInserting()
            if (r4 == 0) goto L_0x0321
            r10.createNode(r15)
            goto L_0x0324
        L_0x0321:
            r10.useNode()
        L_0x0324:
            r10.disableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m2787constructorimpl(r10)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            r34 = r15
            kotlin.jvm.functions.Function2 r15 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r4, r13, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r4, r5, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r4, r9, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r4, r2, r15)
            r10.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r4)
            int r15 = r6 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r35 = r2
            r2 = r32
            r2.invoke(r4, r10, r15)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r4)
            int r4 = r6 >> 9
            r4 = r4 & 14
            r15 = r10
            r32 = 0
            r36 = r2
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r4 & 11
            r37 = r4
            r4 = 2
            if (r2 != r4) goto L_0x03a5
            boolean r2 = r15.getSkipping()
            if (r2 != 0) goto L_0x0396
            goto L_0x03a5
        L_0x0396:
            r15.skipToGroupEnd()
            r38 = r0
            r48 = r5
            r30 = r6
            r49 = r8
            r56 = r9
            goto L_0x0523
        L_0x03a5:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r4 = r8 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r16 = 6
            r4 = r4 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r45 = r15
            r46 = 0
            r47 = r2
            r2 = 752355157(0x2cd80755, float:6.1399033E-12)
            r48 = r5
            r5 = r45
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "C204@9034L145,*213@9463L7,218@9754L120,249@10887L287:NavigationRail.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            r2 = r4 & 81
            r45 = r4
            r4 = 16
            if (r2 != r4) goto L_0x03e2
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x03d5
            goto L_0x03e2
        L_0x03d5:
            r5.skipToGroupEnd()
            r38 = r0
            r30 = r6
            r49 = r8
            r56 = r9
            goto L_0x051f
        L_0x03e2:
            if (r12 == 0) goto L_0x03e9
            r2 = 1065353216(0x3f800000, float:1.0)
            r38 = r2
            goto L_0x03eb
        L_0x03e9:
            r38 = 0
        L_0x03eb:
            r2 = 150(0x96, float:2.1E-43)
            r4 = 0
            r30 = r6
            r49 = r8
            r6 = 0
            r8 = 6
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r4, r6, r8, r6)
            r39 = r2
            androidx.compose.animation.core.AnimationSpec r39 = (androidx.compose.animation.core.AnimationSpec) r39
            r40 = 0
            r41 = 0
            r43 = 48
            r44 = 12
            r42 = r5
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r38, r39, r40, r41, r42, r43, r44)
            r20 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r6 = 0
            r8 = 0
            r17 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r6, r14)
            java.lang.Object r6 = r5.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r4 = r6
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            r6 = 0
            int r8 = r4.m5961roundToPx0680j_4(r11)
            androidx.compose.material3.tokens.NavigationRailTokens r11 = androidx.compose.material3.tokens.NavigationRailTokens.INSTANCE
            float r11 = r11.m2530getActiveIndicatorWidthD9Ej5fM()
            int r11 = r4.m5961roundToPx0680j_4(r11)
            int r14 = r8 - r11
            float r14 = (float) r14
            r59 = r4
            r4 = 2
            float r4 = (float) r4
            float r14 = r14 / r4
            r17 = r8
            r56 = r9
            r4 = 0
            long r8 = androidx.compose.ui.geometry.OffsetKt.Offset(r14, r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2904boximpl(r8)
            int r6 = r1 >> 24
            r6 = r6 & 14
            r11 = 0
            r14 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r5.startReplaceableGroup(r14)
            java.lang.String r14 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r14)
            boolean r14 = r5.changed((java.lang.Object) r0)
            boolean r17 = r5.changed((java.lang.Object) r4)
            r14 = r14 | r17
            r59 = r5
            r17 = 0
            r20 = r4
            java.lang.Object r4 = r59.rememberedValue()
            r21 = 0
            if (r14 != 0) goto L_0x048a
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r6
            java.lang.Object r6 = r22.getEmpty()
            if (r4 != r6) goto L_0x0482
            goto L_0x048c
        L_0x0482:
            r38 = r0
            r0 = r4
            r22 = r0
            r4 = r59
            goto L_0x04a3
        L_0x048a:
            r23 = r6
        L_0x048c:
            r6 = 0
            r22 = r4
            androidx.compose.material3.MappedInteractionSource r4 = new androidx.compose.material3.MappedInteractionSource
            r31 = r6
            r6 = r0
            androidx.compose.foundation.interaction.InteractionSource r6 = (androidx.compose.foundation.interaction.InteractionSource) r6
            r38 = r0
            r0 = 0
            r4.<init>(r6, r8, r0)
            r0 = r4
            r4 = r59
            r4.updateRememberedValue(r0)
        L_0x04a3:
            r5.endReplaceableGroup()
            androidx.compose.material3.MappedInteractionSource r0 = (androidx.compose.material3.MappedInteractionSource) r0
            if (r7 == 0) goto L_0x04c6
            r4 = 1104516937(0x41d59749, float:26.69887)
            r5.startReplaceableGroup(r4)
            java.lang.String r4 = "223@9980L9"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r4)
            androidx.compose.material3.tokens.NavigationRailTokens r4 = androidx.compose.material3.tokens.NavigationRailTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r4 = r4.getActiveIndicatorShape()
            r6 = 6
            androidx.compose.ui.graphics.Shape r4 = androidx.compose.material3.ShapesKt.toShape(r4, r5, r6)
            r5.endReplaceableGroup()
            goto L_0x04df
        L_0x04c6:
            r4 = 1104517018(0x41d5979a, float:26.699024)
            r5.startReplaceableGroup(r4)
            java.lang.String r4 = "225@10068L9"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r4)
            androidx.compose.material3.tokens.NavigationRailTokens r4 = androidx.compose.material3.tokens.NavigationRailTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r4 = r4.getNoLabelActiveIndicatorShape()
            r6 = 6
            androidx.compose.ui.graphics.Shape r4 = androidx.compose.material3.ShapesKt.toShape(r4, r5, r6)
            r5.endReplaceableGroup()
        L_0x04df:
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1 r6 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
            r6.<init>(r4, r0)
            r11 = 211026382(0xc9401ce, float:2.2804097E-31)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r11, r14, r6)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1 r11 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
            r11.<init>(r3, r1, r4, r2)
            r53 = r0
            r0 = -1862011490(0xffffffff9103f59e, float:-1.0409764E-28)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r0, r14, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            float r21 = m2019NavigationRailItem$lambda5$lambda2(r2)
            int r11 = r1 >> 6
            r14 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r14
            r11 = r11 | 438(0x1b6, float:6.14E-43)
            r16 = r6
            r17 = r0
            r18 = r29
            r20 = r27
            r22 = r5
            r23 = r11
            NavigationRailItemBaselineLayout(r16, r17, r18, r19, r20, r21, r22, r23)
        L_0x051f:
            r5.endReplaceableGroup()
        L_0x0523:
            r15.endReplaceableGroup()
            r10.endReplaceableGroup()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x053e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x053e:
            r13 = r54
            r14 = r55
            r17 = r1
            r16 = r3
            r15 = r7
        L_0x0547:
            androidx.compose.runtime.ScopeUpdateScope r11 = r10.endRestartGroup()
            if (r11 != 0) goto L_0x0550
            r19 = r10
            goto L_0x0574
        L_0x0550:
            androidx.compose.material3.NavigationRailKt$NavigationRailItem$3 r18 = new androidx.compose.material3.NavigationRailKt$NavigationRailItem$3
            r0 = r18
            r1 = r50
            r2 = r51
            r3 = r52
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r27
            r8 = r16
            r9 = r38
            r19 = r10
            r10 = r60
            r12 = r11
            r11 = r61
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0574:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.NavigationRailItem(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationRailItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationRailItem$lambda-5$lambda-2  reason: not valid java name */
    public static final float m2019NavigationRailItem$lambda5$lambda2(State<Float> $animationProgress$delegate) {
        return ((Number) $animationProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void NavigationRailItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> indicatorRipple, Function2<? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, float animationProgress, Composer $composer, int $changed) {
        Composer $composer2;
        Function2<? super Composer, ? super Integer, Unit> function2 = indicatorRipple;
        Function2<? super Composer, ? super Integer, Unit> function22 = indicator;
        Function2<? super Composer, ? super Integer, Unit> function23 = icon;
        Function2<? super Composer, ? super Integer, Unit> function24 = label;
        boolean z = alwaysShowLabel;
        float f = animationProgress;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(-876426901);
        ComposerKt.sourceInformation($composer3, "C(NavigationRailItemBaselineLayout)P(4,3,2,5)389@16503L2562:NavigationRail.kt#uh7d8r");
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
                ComposerKt.traceEventStart(-876426901, $dirty2, -1, "androidx.compose.material3.NavigationRailItemBaselineLayout (NavigationRail.kt:381)");
            }
            MeasurePolicy measurePolicy$iv = new NavigationRailKt$NavigationRailItemBaselineLayout$2(f, function24, z);
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
            $composer4.startReplaceableGroup(2083574754);
            ComposerKt.sourceInformation($composer4, "C390@16520L17,395@16618L50,398@16711L178:NavigationRail.kt#uh7d8r");
            int i2 = $changed$iv$iv;
            if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                function2.invoke($composer4, Integer.valueOf($dirty2 & 14));
                $composer4.startReplaceableGroup(935754904);
                ComposerKt.sourceInformation($composer4, "392@16587L11");
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
                    $composer5.startReplaceableGroup(-1582262808);
                    ComposerKt.sourceInformation($composer5, "C395@16660L6:NavigationRail.kt#uh7d8r");
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
                    Modifier modifier$iv3 = AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.Companion, LabelLayoutIdTag), z ? 1.0f : animationProgress);
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
                        $composer6.startReplaceableGroup(6101178);
                        ComposerKt.sourceInformation($composer6, "C402@16880L7:NavigationRail.kt#uh7d8r");
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
        endRestartGroup.updateScope(new NavigationRailKt$NavigationRailItemBaselineLayout$3(indicatorRipple, indicator, icon, label, alwaysShowLabel, animationProgress, $changed));
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4  reason: not valid java name */
    public static final MeasureResult m2023placeIconX9ElhV4(MeasureScope $this$placeIcon_u2dX9ElhV4, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints) {
        int width = ConstraintsKt.m5944constrainWidthK40F9xA(constraints, Math.max(iconPlaceable.getWidth(), Math.max(indicatorRipplePlaceable.getWidth(), indicatorPlaceable != null ? indicatorPlaceable.getWidth() : 0)));
        int height = Constraints.m5929getMaxHeightimpl(constraints);
        return MeasureScope.layout$default($this$placeIcon_u2dX9ElhV4, width, height, (Map) null, new NavigationRailKt$placeIcon$1(indicatorPlaceable, iconPlaceable, (width - iconPlaceable.getWidth()) / 2, (height - iconPlaceable.getHeight()) / 2, indicatorRipplePlaceable, (width - indicatorRipplePlaceable.getWidth()) / 2, (height - indicatorRipplePlaceable.getHeight()) / 2, width, height), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0  reason: not valid java name */
    public static final MeasureResult m2024placeLabelAndIconzUg2_y0(MeasureScope $this$placeLabelAndIcon_u2dzUg2_y0, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, boolean alwaysShowLabel, float animationProgress) {
        MeasureScope measureScope = $this$placeLabelAndIcon_u2dzUg2_y0;
        int height = Constraints.m5929getMaxHeightimpl(constraints);
        float f = NavigationRailItemVerticalPadding;
        int labelY = (height - labelPlaceable.getHeight()) - measureScope.m5961roundToPx0680j_4(f);
        int selectedIconY = measureScope.m5961roundToPx0680j_4(f);
        int iconDistance = (alwaysShowLabel ? selectedIconY : (height - iconPlaceable.getHeight()) / 2) - selectedIconY;
        int offset = MathKt.roundToInt(((float) iconDistance) * (((float) 1) - animationProgress));
        int width = ConstraintsKt.m5944constrainWidthK40F9xA(constraints, Math.max(iconPlaceable.getWidth(), Math.max(labelPlaceable.getWidth(), indicatorPlaceable != null ? indicatorPlaceable.getWidth() : 0)));
        int i = iconDistance;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dzUg2_y0, width, height, (Map) null, new NavigationRailKt$placeLabelAndIcon$1(indicatorPlaceable, alwaysShowLabel, animationProgress, labelPlaceable, (width - labelPlaceable.getWidth()) / 2, labelY, offset, iconPlaceable, (width - iconPlaceable.getWidth()) / 2, selectedIconY, indicatorRipplePlaceable, (width - indicatorRipplePlaceable.getWidth()) / 2, selectedIconY - measureScope.m5961roundToPx0680j_4(IndicatorVerticalPaddingWithLabel), width, $this$placeLabelAndIcon_u2dzUg2_y0), 4, (Object) null);
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }
}
