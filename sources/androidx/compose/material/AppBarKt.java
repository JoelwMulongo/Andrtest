package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aq\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0001\u0010\u001f\u001a\u00020\n2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\n0!¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010!¢\u0006\u0002\b\u00172\u001e\b\u0002\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001ae\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\b\u001a,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0-2\u0006\u0010.\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010/\u001a\u00020)H\u0000\u001a\u0011\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020)H\b\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "F", "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-celAv9A", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", "x", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
public final class AppBarKt {
    /* access modifiers changed from: private */
    public static final float AppBarHeight = Dp.m5986constructorimpl((float) 56);
    /* access modifiers changed from: private */
    public static final float AppBarHorizontalPadding = Dp.m5986constructorimpl((float) 4);
    /* access modifiers changed from: private */
    public static final float BottomAppBarCutoutOffset = Dp.m5986constructorimpl((float) 8);
    /* access modifiers changed from: private */
    public static final float BottomAppBarRoundedEdgeRadius = Dp.m5986constructorimpl((float) 4);
    /* access modifiers changed from: private */
    public static final Modifier TitleIconModifier = SizeKt.m835width3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m5986constructorimpl(Dp.m5986constructorimpl((float) 72) - AppBarHorizontalPadding));
    /* access modifiers changed from: private */
    public static final Modifier TitleInsetWithoutIcon = SizeKt.m835width3ABfNKs(Modifier.Companion, Dp.m5986constructorimpl(Dp.m5986constructorimpl((float) 16) - AppBarHorizontalPadding));

    /* renamed from: TopAppBar-xWeB9-s  reason: not valid java name */
    public static final void m1371TopAppBarxWeB9s(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, long backgroundColor, long contentColor, float elevation, Composer $composer, int $changed, int i) {
        Function2 navigationIcon2;
        Function3 actions2;
        long backgroundColor2;
        long contentColor2;
        float elevation2;
        float elevation3;
        long contentColor3;
        long backgroundColor3;
        Function3 actions3;
        Function2 navigationIcon3;
        Modifier modifier2;
        int $dirty;
        long contentColor4;
        Modifier modifier3;
        int i2;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function2 = title;
        int i4 = $changed;
        Intrinsics.checkNotNullParameter(function2, "title");
        Composer $composer2 = $composer.startRestartGroup(-2087748139);
        ComposerKt.sourceInformation($composer2, "C(TopAppBar)P(6,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)81@3902L6,82@3951L32,85@4047L1254:AppBar.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
            Modifier modifier4 = modifier;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            navigationIcon2 = navigationIcon;
        } else if ((i4 & 896) == 0) {
            navigationIcon2 = navigationIcon;
            $dirty2 |= $composer2.changedInstance(navigationIcon2) ? 256 : 128;
        } else {
            navigationIcon2 = navigationIcon;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            actions2 = actions;
        } else if ((i4 & 7168) == 0) {
            actions2 = actions;
            $dirty2 |= $composer2.changedInstance(actions2) ? 2048 : 1024;
        } else {
            actions2 = actions;
        }
        if ((57344 & i4) == 0) {
            if ((i & 16) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i4 & 458752) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
            elevation2 = elevation;
        } else if ((i4 & 3670016) == 0) {
            elevation2 = elevation;
            $dirty2 |= $composer2.changed(elevation2) ? 1048576 : 524288;
        } else {
            elevation2 = elevation;
        }
        if (($dirty2 & 2995931) != 599186 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i6 != 0) {
                    navigationIcon2 = null;
                }
                if (i7 != 0) {
                    actions2 = ComposableSingletons$AppBarKt.INSTANCE.m1468getLambda1$material_release();
                }
                if ((i & 16) != 0) {
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    contentColor2 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 12) & 14);
                    $dirty2 &= -458753;
                }
                if (i8 != 0) {
                    $dirty = $dirty2;
                    elevation2 = AppBarDefaults.INSTANCE.m1367getTopAppBarElevationD9Ej5fM();
                    contentColor4 = contentColor2;
                } else {
                    $dirty = $dirty2;
                    contentColor4 = contentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & -458753;
                    contentColor4 = contentColor2;
                    modifier3 = modifier;
                } else {
                    modifier3 = modifier;
                    $dirty = $dirty2;
                    contentColor4 = contentColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087748139, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
            }
            m1368AppBarcelAv9A(backgroundColor2, contentColor4, elevation2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier3, ComposableLambdaKt.composableLambda($composer2, -1484077694, true, new AppBarKt$TopAppBar$1(navigationIcon2, $dirty, function2, actions2)), $composer2, (($dirty >> 12) & 14) | 1600512 | (($dirty >> 12) & 112) | (($dirty >> 12) & 896) | (($dirty << 12) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            contentColor3 = contentColor4;
            int i9 = $dirty;
            navigationIcon3 = navigationIcon2;
            actions3 = actions2;
            backgroundColor3 = backgroundColor2;
            elevation3 = elevation2;
        } else {
            $composer2.skipToGroupEnd();
            int i10 = $dirty2;
            actions3 = actions2;
            backgroundColor3 = backgroundColor2;
            elevation3 = elevation2;
            contentColor3 = contentColor2;
            modifier2 = modifier;
            navigationIcon3 = navigationIcon2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new AppBarKt$TopAppBar$2(title, modifier2, navigationIcon3, actions3, backgroundColor3, contentColor3, elevation3, $changed, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e3  */
    /* renamed from: TopAppBar-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1370TopAppBarHsRjFd4(androidx.compose.ui.Modifier r24, long r25, long r27, float r29, androidx.compose.foundation.layout.PaddingValues r30, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r12 = r31
            r13 = r33
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1897058582(0x7112d116, float:7.270013E29)
            r1 = r32
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TopAppBar)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)156@6973L6,157@7022L32,162@7231L182:AppBar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r33
            r2 = r34 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r24
            goto L_0x0035
        L_0x0022:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r24
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r24
        L_0x0035:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r34 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r25
            boolean r6 = r14.changed((long) r4)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r25
        L_0x004a:
            r6 = 16
        L_0x004c:
            r1 = r1 | r6
            goto L_0x0050
        L_0x004e:
            r4 = r25
        L_0x0050:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0069
            r6 = r34 & 4
            if (r6 != 0) goto L_0x0063
            r6 = r27
            boolean r8 = r14.changed((long) r6)
            if (r8 == 0) goto L_0x0065
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r6 = r27
        L_0x0065:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r8
            goto L_0x006b
        L_0x0069:
            r6 = r27
        L_0x006b:
            r8 = r34 & 8
            if (r8 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r29
            goto L_0x0089
        L_0x0074:
            r9 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0087
            r9 = r29
            boolean r10 = r14.changed((float) r9)
            if (r10 == 0) goto L_0x0083
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r10
            goto L_0x0089
        L_0x0087:
            r9 = r29
        L_0x0089:
            r10 = r34 & 16
            if (r10 == 0) goto L_0x0092
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r11 = r30
            goto L_0x00a9
        L_0x0092:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r13
            if (r11 != 0) goto L_0x00a7
            r11 = r30
            boolean r15 = r14.changed((java.lang.Object) r11)
            if (r15 == 0) goto L_0x00a3
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r1 = r1 | r15
            goto L_0x00a9
        L_0x00a7:
            r11 = r30
        L_0x00a9:
            r15 = r34 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00b3
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b1:
            r1 = r1 | r15
            goto L_0x00c3
        L_0x00b3:
            r15 = r13 & r16
            if (r15 != 0) goto L_0x00c3
            boolean r15 = r14.changedInstance(r12)
            if (r15 == 0) goto L_0x00c0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00c0:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b1
        L_0x00c3:
            r15 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r15 & r1
            r0 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r0) goto L_0x00e3
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00d3
            goto L_0x00e3
        L_0x00d3:
            r14.skipToGroupEnd()
            r17 = r1
            r15 = r3
            r18 = r4
            r20 = r6
            r22 = r9
            r23 = r11
            goto L_0x01c1
        L_0x00e3:
            r14.startDefaults()
            r0 = r13 & 1
            if (r0 == 0) goto L_0x0117
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00f1
            goto L_0x0117
        L_0x00f1:
            r14.skipToGroupEnd()
            r0 = r34 & 2
            if (r0 == 0) goto L_0x00fa
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00fa:
            r0 = r34 & 4
            if (r0 == 0) goto L_0x010c
            r0 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r15 = r3
            r18 = r4
            r20 = r6
            r22 = r9
            r23 = r11
            r11 = r0
            goto L_0x0167
        L_0x010c:
            r15 = r3
            r18 = r4
            r20 = r6
            r22 = r9
            r23 = r11
            r11 = r1
            goto L_0x0167
        L_0x0117:
            if (r2 == 0) goto L_0x011e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x011f
        L_0x011e:
            r0 = r3
        L_0x011f:
            r2 = r34 & 2
            if (r2 == 0) goto L_0x0131
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r14, r3)
            long r2 = androidx.compose.material.ColorsKt.getPrimarySurface(r2)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0132
        L_0x0131:
            r2 = r4
        L_0x0132:
            r4 = r34 & 4
            if (r4 == 0) goto L_0x0141
            int r4 = r1 >> 3
            r4 = r4 & 14
            long r4 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r2, r14, r4)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r4
        L_0x0141:
            if (r8 == 0) goto L_0x014a
            androidx.compose.material.AppBarDefaults r4 = androidx.compose.material.AppBarDefaults.INSTANCE
            float r4 = r4.m1367getTopAppBarElevationD9Ej5fM()
            r9 = r4
        L_0x014a:
            if (r10 == 0) goto L_0x015d
            androidx.compose.material.AppBarDefaults r4 = androidx.compose.material.AppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r4 = r4.getContentPadding()
            r15 = r0
            r11 = r1
            r18 = r2
            r23 = r4
            r20 = r6
            r22 = r9
            goto L_0x0167
        L_0x015d:
            r15 = r0
            r18 = r2
            r20 = r6
            r22 = r9
            r23 = r11
            r11 = r1
        L_0x0167:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0179
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.TopAppBar (AppBar.kt:154)"
            r2 = 1897058582(0x7112d116, float:7.270013E29)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r0, r1)
        L_0x0179:
            androidx.compose.ui.graphics.Shape r6 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            int r0 = r11 >> 3
            r0 = r0 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r1 = r11 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r11 >> 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r11 >> 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r11 << 15
            r1 = r1 & r16
            r0 = r0 | r1
            r1 = 3670016(0x380000, float:5.142788E-39)
            int r2 = r11 << 3
            r1 = r1 & r2
            r10 = r0 | r1
            r16 = 0
            r0 = r18
            r2 = r20
            r4 = r22
            r5 = r23
            r7 = r15
            r8 = r31
            r9 = r14
            r17 = r11
            r11 = r16
            m1368AppBarcelAv9A(r0, r2, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c1:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x01c8
            goto L_0x01e5
        L_0x01c8:
            androidx.compose.material.AppBarKt$TopAppBar$3 r16 = new androidx.compose.material.AppBarKt$TopAppBar$3
            r0 = r16
            r1 = r15
            r2 = r18
            r4 = r20
            r6 = r22
            r7 = r23
            r8 = r31
            r9 = r33
            r10 = r34
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m1370TopAppBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x010b  */
    /* renamed from: BottomAppBar-Y1yfwus  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1369BottomAppBarY1yfwus(androidx.compose.ui.Modifier r26, long r27, long r29, androidx.compose.ui.graphics.Shape r31, float r32, androidx.compose.foundation.layout.PaddingValues r33, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r12 = r34
            r13 = r36
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1651948973(0xffffffff9d894253, float:-3.6332176E-21)
            r1 = r35
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BottomAppBar)P(6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)216@9902L6,217@9951L32,223@10232L7,229@10422L152:AppBar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r36
            r2 = r37 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r26
            goto L_0x0035
        L_0x0022:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r26
            boolean r4 = r14.changed((java.lang.Object) r3)
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
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r37 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r27
            boolean r6 = r14.changed((long) r4)
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
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0069
            r6 = r37 & 4
            if (r6 != 0) goto L_0x0063
            r6 = r29
            boolean r8 = r14.changed((long) r6)
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
            r8 = r37 & 8
            if (r8 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r31
            goto L_0x0089
        L_0x0074:
            r9 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0087
            r9 = r31
            boolean r10 = r14.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0083
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r10
            goto L_0x0089
        L_0x0087:
            r9 = r31
        L_0x0089:
            r10 = r37 & 16
            if (r10 == 0) goto L_0x0092
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r11 = r32
            goto L_0x00a9
        L_0x0092:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r13
            if (r11 != 0) goto L_0x00a7
            r11 = r32
            boolean r15 = r14.changed((float) r11)
            if (r15 == 0) goto L_0x00a3
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r1 = r1 | r15
            goto L_0x00a9
        L_0x00a7:
            r11 = r32
        L_0x00a9:
            r15 = r37 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00b6
            r17 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r17
            r0 = r33
            goto L_0x00cc
        L_0x00b6:
            r17 = r13 & r16
            if (r17 != 0) goto L_0x00ca
            r0 = r33
            boolean r18 = r14.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00c5
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c5:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c7:
            r1 = r1 | r18
            goto L_0x00cc
        L_0x00ca:
            r0 = r33
        L_0x00cc:
            r18 = r37 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00d7
            r18 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d4:
            r1 = r1 | r18
            goto L_0x00e7
        L_0x00d7:
            r18 = r13 & r19
            if (r18 != 0) goto L_0x00e7
            boolean r18 = r14.changedInstance(r12)
            if (r18 == 0) goto L_0x00e4
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00e4:
            r18 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d4
        L_0x00e7:
            r18 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r18
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x010b
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00f8
            goto L_0x010b
        L_0x00f8:
            r14.skipToGroupEnd()
            r15 = r26
            r24 = r33
            r25 = r1
            r20 = r4
            r22 = r6
            r16 = r9
            r18 = r11
            goto L_0x022a
        L_0x010b:
            r14.startDefaults()
            r0 = r13 & 1
            if (r0 == 0) goto L_0x0144
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0119
            goto L_0x0144
        L_0x0119:
            r14.skipToGroupEnd()
            r0 = r37 & 2
            if (r0 == 0) goto L_0x0122
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0122:
            r0 = r37 & 4
            if (r0 == 0) goto L_0x0136
            r0 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r15 = r26
            r24 = r33
            r10 = r0
            r20 = r4
            r22 = r6
            r18 = r11
            r11 = r9
            goto L_0x019a
        L_0x0136:
            r15 = r26
            r24 = r33
            r10 = r1
            r20 = r4
            r22 = r6
            r18 = r11
            r11 = r9
            goto L_0x019a
        L_0x0144:
            if (r2 == 0) goto L_0x014b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x014d
        L_0x014b:
            r0 = r26
        L_0x014d:
            r2 = r37 & 2
            if (r2 == 0) goto L_0x015f
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r14, r3)
            long r2 = androidx.compose.material.ColorsKt.getPrimarySurface(r2)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            r4 = r2
        L_0x015f:
            r2 = r37 & 4
            if (r2 == 0) goto L_0x016e
            int r2 = r1 >> 3
            r2 = r2 & 14
            long r2 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r4, r14, r2)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r2
        L_0x016e:
            if (r8 == 0) goto L_0x0172
            r2 = 0
            r9 = r2
        L_0x0172:
            if (r10 == 0) goto L_0x017b
            androidx.compose.material.AppBarDefaults r2 = androidx.compose.material.AppBarDefaults.INSTANCE
            float r2 = r2.m1366getBottomAppBarElevationD9Ej5fM()
            r11 = r2
        L_0x017b:
            if (r15 == 0) goto L_0x018f
            androidx.compose.material.AppBarDefaults r2 = androidx.compose.material.AppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r2 = r2.getContentPadding()
            r15 = r0
            r10 = r1
            r24 = r2
            r20 = r4
            r22 = r6
            r18 = r11
            r11 = r9
            goto L_0x019a
        L_0x018f:
            r24 = r33
            r15 = r0
            r10 = r1
            r20 = r4
            r22 = r6
            r18 = r11
            r11 = r9
        L_0x019a:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ac
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.BottomAppBar (AppBar.kt:214)"
            r2 = -1651948973(0xffffffff9d894253, float:-3.6332176E-21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r0, r1)
        L_0x01ac:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ScaffoldKt.getLocalFabPlacement()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r3 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r9 = r3
            androidx.compose.material.FabPlacement r9 = (androidx.compose.material.FabPlacement) r9
            if (r11 == 0) goto L_0x01de
            r0 = 0
            if (r9 == 0) goto L_0x01d3
            boolean r1 = r9.isDocked()
            r2 = 1
            if (r1 != r2) goto L_0x01d3
            r0 = r2
        L_0x01d3:
            if (r0 == 0) goto L_0x01de
            androidx.compose.material.BottomAppBarCutoutShape r0 = new androidx.compose.material.BottomAppBarCutoutShape
            r0.<init>(r11, r9)
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            r6 = r0
            goto L_0x01e3
        L_0x01de:
            androidx.compose.ui.graphics.Shape r0 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r6 = r0
        L_0x01e3:
            int r0 = r10 >> 3
            r0 = r0 & 14
            int r1 = r10 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r10 >> 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r10 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r10 << 15
            r1 = r1 & r16
            r0 = r0 | r1
            r1 = r10 & r19
            r16 = r0 | r1
            r17 = 0
            r0 = r20
            r2 = r22
            r4 = r18
            r5 = r24
            r7 = r15
            r8 = r34
            r19 = r9
            r9 = r14
            r25 = r10
            r10 = r16
            r16 = r11
            r11 = r17
            m1368AppBarcelAv9A(r0, r2, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x022a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x022a:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x0231
            goto L_0x0251
        L_0x0231:
            androidx.compose.material.AppBarKt$BottomAppBar$1 r17 = new androidx.compose.material.AppBarKt$BottomAppBar$1
            r0 = r17
            r1 = r15
            r2 = r20
            r4 = r22
            r6 = r16
            r7 = r18
            r8 = r24
            r9 = r34
            r10 = r36
            r12 = r11
            r11 = r37
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0251:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m1369BottomAppBarY1yfwus(androidx.compose.ui.Modifier, long, long, androidx.compose.ui.graphics.Shape, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float square(float x) {
        return x * x;
    }

    public static final float calculateCutoutCircleYIntercept(float cutoutRadius, float verticalOffset) {
        return -((float) Math.sqrt((double) ((cutoutRadius * cutoutRadius) - (verticalOffset * verticalOffset))));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float controlPointX, float verticalOffset, float radius) {
        Pair pair;
        Float f;
        Float f2;
        Float f3;
        Float f4;
        float a = controlPointX;
        float b = verticalOffset;
        float r = radius;
        float discriminant = b * b * r * r * (((a * a) + (b * b)) - (r * r));
        float divisor = (a * a) + (b * b);
        float bCoefficient = r * r * a;
        float xSolutionA = (bCoefficient - ((float) Math.sqrt((double) discriminant))) / divisor;
        float xSolutionB = (((float) Math.sqrt((double) discriminant)) + bCoefficient) / divisor;
        float ySolutionA = (float) Math.sqrt((double) ((r * r) - (xSolutionA * xSolutionA)));
        float ySolutionB = (float) Math.sqrt((double) ((r * r) - (xSolutionB * xSolutionB)));
        if (b > 0.0f) {
            if (ySolutionA > ySolutionB) {
                f4 = Float.valueOf(xSolutionA);
                f3 = Float.valueOf(ySolutionA);
            } else {
                f4 = Float.valueOf(xSolutionB);
                f3 = Float.valueOf(ySolutionB);
            }
            pair = TuplesKt.to(f4, f3);
        } else {
            if (ySolutionA < ySolutionB) {
                f2 = Float.valueOf(xSolutionA);
                f = Float.valueOf(ySolutionA);
            } else {
                f2 = Float.valueOf(xSolutionB);
                f = Float.valueOf(ySolutionB);
            }
            pair = TuplesKt.to(f2, f);
        }
        float xSolution = ((Number) pair.component1()).floatValue();
        float ySolution = ((Number) pair.component2()).floatValue();
        return TuplesKt.to(Float.valueOf(xSolution), Float.valueOf(xSolution < controlPointX ? -ySolution : ySolution));
    }

    /* access modifiers changed from: private */
    /* renamed from: AppBar-celAv9A  reason: not valid java name */
    public static final void m1368AppBarcelAv9A(long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, Shape shape, Modifier modifier, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        PaddingValues paddingValues = contentPadding;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1249680788);
        ComposerKt.sourceInformation($composer2, "C(AppBar)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3,6,5)513@22344L583:AppBar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            long j = backgroundColor;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(backgroundColor) ? 4 : 2;
        } else {
            long j2 = backgroundColor;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
            long j3 = contentColor;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 32 : 16;
        } else {
            long j4 = contentColor;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
            float f = elevation;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer2.changed(elevation) ? 256 : 128;
        } else {
            float f2 = elevation;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) paddingValues) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
            Shape shape2 = shape;
        } else if ((57344 & i2) == 0) {
            $dirty |= $composer2.changed((Object) shape) ? 16384 : 8192;
        } else {
            Shape shape3 = shape;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            modifier2 = modifier;
        } else if ((i2 & 458752) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if ((3670016 & i2) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((2995931 & $dirty) != 599186 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249680788, $dirty, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
            }
            SurfaceKt.m1620SurfaceFjzlyU(modifier2, shape, backgroundColor, contentColor, (BorderStroke) null, elevation, ComposableLambdaKt.composableLambda($composer2, -1027830352, true, new AppBarKt$AppBar$1(paddingValues, function3, $dirty)), $composer2, (($dirty >> 15) & 14) | 1572864 | (($dirty >> 9) & 112) | (($dirty << 6) & 896) | (($dirty << 6) & 7168) | (($dirty << 9) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i4 = $dirty;
            Composer composer = $composer2;
            return;
        }
        int i5 = $dirty;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new AppBarKt$AppBar$2(backgroundColor, contentColor, elevation, contentPadding, shape, modifier3, content, $changed, i));
    }
}
