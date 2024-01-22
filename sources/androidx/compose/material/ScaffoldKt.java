package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¢\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a£\u0001\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00172\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a!\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0014H\u0007¢\u0006\u0002\u00107\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-MDYNRJg", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
public final class ScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m5986constructorimpl((float) 16);
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(ScaffoldKt$LocalFabPlacement$1.INSTANCE);

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(1569641925);
        ComposerKt.sourceInformation($composer, "C(rememberScaffoldState)63@2263L39,64@2347L32,65@2399L62:Scaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, $composer, 6, 2);
        }
        if ((i & 2) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv2 = new SnackbarHostState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, $changed, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:62)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv = new ScaffoldState(drawerState, snackbarHostState);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v1, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r72v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v2, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v2, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r72v2, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r72v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v30, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v7, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v2, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v3, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v9, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x01d6, code lost:
        if (r11.changed(r68) != false) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x01f0, code lost:
        if (r11.changed(r70) != false) goto L_0x01f7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0522  */
    /* renamed from: Scaffold-27mzLpw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1589Scaffold27mzLpw(androidx.compose.ui.Modifier r54, androidx.compose.material.ScaffoldState r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, int r60, boolean r61, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, boolean r63, androidx.compose.ui.graphics.Shape r64, float r65, long r66, long r68, long r70, long r72, long r74, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, androidx.compose.runtime.Composer r77, int r78, int r79, int r80) {
        /*
            r15 = r76
            r13 = r78
            r14 = r79
            r12 = r80
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 1037492569(0x3dd6e159, float:0.104922004)
            r1 = r77
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)160@7052L23,169@7562L6,171@7677L6,172@7725L38,173@7810L10,174@7865L6,175@7910L32:Scaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r78
            r1 = r79
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0028
            r0 = r0 | 6
            r5 = r54
            goto L_0x003b
        L_0x0028:
            r5 = r13 & 14
            if (r5 != 0) goto L_0x0039
            r5 = r54
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0036
            r6 = 4
            goto L_0x0037
        L_0x0036:
            r6 = 2
        L_0x0037:
            r0 = r0 | r6
            goto L_0x003b
        L_0x0039:
            r5 = r54
        L_0x003b:
            r6 = r13 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0054
            r6 = r12 & 2
            if (r6 != 0) goto L_0x004e
            r6 = r55
            boolean r9 = r11.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x0050
            r9 = 32
            goto L_0x0052
        L_0x004e:
            r6 = r55
        L_0x0050:
            r9 = 16
        L_0x0052:
            r0 = r0 | r9
            goto L_0x0056
        L_0x0054:
            r6 = r55
        L_0x0056:
            r9 = r12 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0061
            r0 = r0 | 384(0x180, float:5.38E-43)
            r3 = r56
            goto L_0x0077
        L_0x0061:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0075
            r3 = r56
            boolean r17 = r11.changedInstance(r3)
            if (r17 == 0) goto L_0x0070
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0072
        L_0x0070:
            r17 = r16
        L_0x0072:
            r0 = r0 | r17
            goto L_0x0077
        L_0x0075:
            r3 = r56
        L_0x0077:
            r17 = r12 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0084
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r4 = r57
            goto L_0x009a
        L_0x0084:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0098
            r4 = r57
            boolean r21 = r11.changedInstance(r4)
            if (r21 == 0) goto L_0x0093
            r21 = r18
            goto L_0x0095
        L_0x0093:
            r21 = r19
        L_0x0095:
            r0 = r0 | r21
            goto L_0x009a
        L_0x0098:
            r4 = r57
        L_0x009a:
            r21 = r12 & 16
            r22 = 57344(0xe000, float:8.0356E-41)
            r23 = 16384(0x4000, float:2.2959E-41)
            r24 = 8192(0x2000, float:1.14794E-41)
            if (r21 == 0) goto L_0x00aa
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r7 = r58
            goto L_0x00c0
        L_0x00aa:
            r25 = r13 & r22
            if (r25 != 0) goto L_0x00be
            r7 = r58
            boolean r26 = r11.changedInstance(r7)
            if (r26 == 0) goto L_0x00b9
            r26 = r23
            goto L_0x00bb
        L_0x00b9:
            r26 = r24
        L_0x00bb:
            r0 = r0 | r26
            goto L_0x00c0
        L_0x00be:
            r7 = r58
        L_0x00c0:
            r26 = r12 & 32
            r27 = 131072(0x20000, float:1.83671E-40)
            r28 = 458752(0x70000, float:6.42848E-40)
            r29 = 65536(0x10000, float:9.18355E-41)
            if (r26 == 0) goto L_0x00d1
            r30 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r30
            r8 = r59
            goto L_0x00e7
        L_0x00d1:
            r30 = r13 & r28
            if (r30 != 0) goto L_0x00e5
            r8 = r59
            boolean r31 = r11.changedInstance(r8)
            if (r31 == 0) goto L_0x00e0
            r31 = r27
            goto L_0x00e2
        L_0x00e0:
            r31 = r29
        L_0x00e2:
            r0 = r0 | r31
            goto L_0x00e7
        L_0x00e5:
            r8 = r59
        L_0x00e7:
            r31 = r12 & 64
            r32 = 3670016(0x380000, float:5.142788E-39)
            if (r31 == 0) goto L_0x00f4
            r33 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r33
            r10 = r60
            goto L_0x010a
        L_0x00f4:
            r33 = r13 & r32
            if (r33 != 0) goto L_0x0108
            r10 = r60
            boolean r34 = r11.changed((int) r10)
            if (r34 == 0) goto L_0x0103
            r34 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0105
        L_0x0103:
            r34 = 524288(0x80000, float:7.34684E-40)
        L_0x0105:
            r0 = r0 | r34
            goto L_0x010a
        L_0x0108:
            r10 = r60
        L_0x010a:
            r3 = r12 & 128(0x80, float:1.794E-43)
            r34 = 29360128(0x1c00000, float:7.052966E-38)
            if (r3 == 0) goto L_0x0117
            r35 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r35
            r4 = r61
            goto L_0x012d
        L_0x0117:
            r35 = r13 & r34
            if (r35 != 0) goto L_0x012b
            r4 = r61
            boolean r35 = r11.changed((boolean) r4)
            if (r35 == 0) goto L_0x0126
            r35 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0128
        L_0x0126:
            r35 = 4194304(0x400000, float:5.877472E-39)
        L_0x0128:
            r0 = r0 | r35
            goto L_0x012d
        L_0x012b:
            r4 = r61
        L_0x012d:
            r4 = r12 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x0138
            r35 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r35
            r5 = r62
            goto L_0x0150
        L_0x0138:
            r35 = 234881024(0xe000000, float:1.5777218E-30)
            r35 = r13 & r35
            if (r35 != 0) goto L_0x014e
            r5 = r62
            boolean r35 = r11.changedInstance(r5)
            if (r35 == 0) goto L_0x0149
            r35 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x014b
        L_0x0149:
            r35 = 33554432(0x2000000, float:9.403955E-38)
        L_0x014b:
            r0 = r0 | r35
            goto L_0x0150
        L_0x014e:
            r5 = r62
        L_0x0150:
            r5 = r12 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x015b
            r35 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r35
            r6 = r63
            goto L_0x0173
        L_0x015b:
            r35 = 1879048192(0x70000000, float:1.58456325E29)
            r35 = r13 & r35
            if (r35 != 0) goto L_0x0171
            r6 = r63
            boolean r35 = r11.changed((boolean) r6)
            if (r35 == 0) goto L_0x016c
            r35 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x016e
        L_0x016c:
            r35 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x016e:
            r0 = r0 | r35
            goto L_0x0173
        L_0x0171:
            r6 = r63
        L_0x0173:
            r35 = r14 & 14
            if (r35 != 0) goto L_0x018d
            r6 = r12 & 1024(0x400, float:1.435E-42)
            if (r6 != 0) goto L_0x0186
            r6 = r64
            boolean r35 = r11.changed((java.lang.Object) r6)
            if (r35 == 0) goto L_0x0188
            r20 = 4
            goto L_0x018a
        L_0x0186:
            r6 = r64
        L_0x0188:
            r20 = 2
        L_0x018a:
            r1 = r1 | r20
            goto L_0x018f
        L_0x018d:
            r6 = r64
        L_0x018f:
            r6 = r12 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0198
            r1 = r1 | 48
            r7 = r65
            goto L_0x01ae
        L_0x0198:
            r20 = r14 & 112(0x70, float:1.57E-43)
            if (r20 != 0) goto L_0x01ac
            r7 = r65
            boolean r20 = r11.changed((float) r7)
            if (r20 == 0) goto L_0x01a7
            r25 = 32
            goto L_0x01a9
        L_0x01a7:
            r25 = 16
        L_0x01a9:
            r1 = r1 | r25
            goto L_0x01ae
        L_0x01ac:
            r7 = r65
        L_0x01ae:
            r7 = r14 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x01c6
            r7 = r12 & 4096(0x1000, float:5.74E-42)
            if (r7 != 0) goto L_0x01c1
            r7 = r66
            boolean r20 = r11.changed((long) r7)
            if (r20 == 0) goto L_0x01c3
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x01c3
        L_0x01c1:
            r7 = r66
        L_0x01c3:
            r1 = r1 | r16
            goto L_0x01c8
        L_0x01c6:
            r7 = r66
        L_0x01c8:
            r7 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x01e0
            r7 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r7 != 0) goto L_0x01d9
            r7 = r68
            boolean r16 = r11.changed((long) r7)
            if (r16 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01d9:
            r7 = r68
        L_0x01db:
            r18 = r19
        L_0x01dd:
            r1 = r1 | r18
            goto L_0x01e2
        L_0x01e0:
            r7 = r68
        L_0x01e2:
            r16 = r14 & r22
            if (r16 != 0) goto L_0x01fa
            r7 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r7 != 0) goto L_0x01f3
            r7 = r70
            boolean r16 = r11.changed((long) r7)
            if (r16 == 0) goto L_0x01f5
            goto L_0x01f7
        L_0x01f3:
            r7 = r70
        L_0x01f5:
            r23 = r24
        L_0x01f7:
            r1 = r1 | r23
            goto L_0x01fc
        L_0x01fa:
            r7 = r70
        L_0x01fc:
            r16 = r14 & r28
            if (r16 != 0) goto L_0x0219
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x0212
            r7 = r72
            boolean r16 = r11.changed((long) r7)
            if (r16 == 0) goto L_0x0214
            r16 = r27
            goto L_0x0216
        L_0x0212:
            r7 = r72
        L_0x0214:
            r16 = r29
        L_0x0216:
            r1 = r1 | r16
            goto L_0x021b
        L_0x0219:
            r7 = r72
        L_0x021b:
            r16 = r14 & r32
            if (r16 != 0) goto L_0x0235
            r16 = r12 & r29
            if (r16 != 0) goto L_0x022e
            r7 = r74
            boolean r16 = r11.changed((long) r7)
            if (r16 == 0) goto L_0x0230
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0232
        L_0x022e:
            r7 = r74
        L_0x0230:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x0232:
            r1 = r1 | r16
            goto L_0x0237
        L_0x0235:
            r7 = r74
        L_0x0237:
            r16 = r12 & r27
            if (r16 == 0) goto L_0x0240
            r16 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x023d:
            r1 = r1 | r16
            goto L_0x0250
        L_0x0240:
            r16 = r14 & r34
            if (r16 != 0) goto L_0x0250
            boolean r16 = r11.changedInstance(r15)
            if (r16 == 0) goto L_0x024d
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x023d
        L_0x024d:
            r16 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x023d
        L_0x0250:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r7 = r0 & r16
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r8) goto L_0x0295
            r7 = 23967451(0x16db6db, float:4.3661218E-38)
            r7 = r7 & r1
            r8 = 4793490(0x492492, float:6.71711E-39)
            if (r7 != r8) goto L_0x0295
            boolean r7 = r11.getSkipping()
            if (r7 != 0) goto L_0x026a
            goto L_0x0295
        L_0x026a:
            r11.skipToGroupEnd()
            r27 = r54
            r28 = r55
            r29 = r56
            r30 = r57
            r31 = r58
            r32 = r59
            r34 = r61
            r35 = r62
            r36 = r63
            r37 = r64
            r38 = r65
            r39 = r66
            r41 = r68
            r43 = r70
            r45 = r72
            r47 = r74
            r49 = r0
            r50 = r1
            r33 = r10
            goto L_0x0519
        L_0x0295:
            r11.startDefaults()
            r7 = r13 & 1
            if (r7 == 0) goto L_0x02fe
            boolean r7 = r11.getDefaultsInvalid()
            if (r7 == 0) goto L_0x02a3
            goto L_0x02fe
        L_0x02a3:
            r11.skipToGroupEnd()
            r2 = r12 & 2
            if (r2 == 0) goto L_0x02ac
            r0 = r0 & -113(0xffffffffffffff8f, float:NaN)
        L_0x02ac:
            r2 = r12 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x02b2
            r1 = r1 & -15
        L_0x02b2:
            r2 = r12 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x02b8
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02b8:
            r2 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x02be
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02be:
            r2 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x02c6
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
        L_0x02c6:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x02d0
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r2
        L_0x02d0:
            r2 = r12 & r29
            if (r2 == 0) goto L_0x02d8
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r2
        L_0x02d8:
            r7 = r56
            r8 = r57
            r9 = r58
            r2 = r61
            r4 = r62
            r5 = r63
            r3 = r64
            r6 = r65
            r19 = r66
            r17 = r68
            r23 = r70
            r25 = r72
            r29 = r74
            r12 = r0
            r13 = r1
            r16 = r10
            r0 = r54
            r1 = r55
            r10 = r59
            goto L_0x0416
        L_0x02fe:
            if (r2 == 0) goto L_0x0305
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0307
        L_0x0305:
            r2 = r54
        L_0x0307:
            r7 = r12 & 2
            if (r7 == 0) goto L_0x0318
            r7 = 0
            r8 = 3
            r54 = r2
            r2 = 0
            r10 = 0
            androidx.compose.material.ScaffoldState r2 = rememberScaffoldState(r2, r10, r11, r7, r8)
            r0 = r0 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x031c
        L_0x0318:
            r54 = r2
            r2 = r55
        L_0x031c:
            if (r9 == 0) goto L_0x0325
            androidx.compose.material.ComposableSingletons$ScaffoldKt r7 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r7 = r7.m1471getLambda1$material_release()
            goto L_0x0327
        L_0x0325:
            r7 = r56
        L_0x0327:
            if (r17 == 0) goto L_0x0330
            androidx.compose.material.ComposableSingletons$ScaffoldKt r8 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r8 = r8.m1472getLambda2$material_release()
            goto L_0x0332
        L_0x0330:
            r8 = r57
        L_0x0332:
            if (r21 == 0) goto L_0x033b
            androidx.compose.material.ComposableSingletons$ScaffoldKt r9 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r9 = r9.m1473getLambda3$material_release()
            goto L_0x033d
        L_0x033b:
            r9 = r58
        L_0x033d:
            if (r26 == 0) goto L_0x0346
            androidx.compose.material.ComposableSingletons$ScaffoldKt r10 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r10 = r10.m1474getLambda4$material_release()
            goto L_0x0348
        L_0x0346:
            r10 = r59
        L_0x0348:
            if (r31 == 0) goto L_0x0351
            androidx.compose.material.FabPosition$Companion r16 = androidx.compose.material.FabPosition.Companion
            int r16 = r16.m1518getEnd5ygKITE()
            goto L_0x0353
        L_0x0351:
            r16 = r60
        L_0x0353:
            if (r3 == 0) goto L_0x0357
            r3 = 0
            goto L_0x0359
        L_0x0357:
            r3 = r61
        L_0x0359:
            if (r4 == 0) goto L_0x035d
            r4 = 0
            goto L_0x035f
        L_0x035d:
            r4 = r62
        L_0x035f:
            if (r5 == 0) goto L_0x0363
            r5 = 1
            goto L_0x0365
        L_0x0363:
            r5 = r63
        L_0x0365:
            r55 = r0
            r0 = r12 & 1024(0x400, float:1.435E-42)
            r77 = r2
            r2 = 6
            if (r0 == 0) goto L_0x037d
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r0 = r0.getShapes(r11, r2)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getLarge()
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            r1 = r1 & -15
            goto L_0x037f
        L_0x037d:
            r0 = r64
        L_0x037f:
            if (r6 == 0) goto L_0x0388
            androidx.compose.material.DrawerDefaults r6 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r6 = r6.m1485getElevationD9Ej5fM()
            goto L_0x038a
        L_0x0388:
            r6 = r65
        L_0x038a:
            r2 = r12 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x03a1
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r57 = r0
            r0 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r11, r0)
            long r17 = r2.m1449getSurface0d7_KjU()
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r2 = r1
            r0 = r17
            goto L_0x03a6
        L_0x03a1:
            r57 = r0
            r2 = r1
            r0 = r66
        L_0x03a6:
            r58 = r3
            r3 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x03b7
            int r3 = r2 >> 6
            r3 = r3 & 14
            long r17 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r0, r11, r3)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x03b9
        L_0x03b7:
            r17 = r68
        L_0x03b9:
            r3 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x03cb
            androidx.compose.material.DrawerDefaults r3 = androidx.compose.material.DrawerDefaults.INSTANCE
            r19 = r0
            r0 = 6
            long r23 = r3.getScrimColor(r11, r0)
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r0
            goto L_0x03cf
        L_0x03cb:
            r19 = r0
            r23 = r70
        L_0x03cf:
            r0 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r12
            if (r0 == 0) goto L_0x03e5
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material.Colors r0 = r0.getColors(r11, r1)
            long r0 = r0.m1438getBackground0d7_KjU()
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = r2 & r3
            goto L_0x03e7
        L_0x03e5:
            r0 = r72
        L_0x03e7:
            r3 = r12 & r29
            if (r3 == 0) goto L_0x0407
            int r3 = r2 >> 15
            r3 = r3 & 14
            long r25 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r0, r11, r3)
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r2 & r3
            r12 = r55
            r3 = r57
            r13 = r2
            r29 = r25
            r2 = r58
            r25 = r0
            r0 = r54
            r1 = r77
            goto L_0x0416
        L_0x0407:
            r12 = r55
            r3 = r57
            r29 = r74
            r25 = r0
            r13 = r2
            r0 = r54
            r2 = r58
            r1 = r77
        L_0x0416:
            r11.endDefaults()
            boolean r21 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r21 == 0) goto L_0x0427
            r14 = 1037492569(0x3dd6e159, float:0.104922004)
            java.lang.String r15 = "androidx.compose.material.Scaffold (Scaffold.kt:158)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r12, r13, r15)
        L_0x0427:
            androidx.compose.material.ScaffoldKt$Scaffold$child$1 r14 = new androidx.compose.material.ScaffoldKt$Scaffold$child$1
            r54 = r14
            r55 = r25
            r57 = r29
            r59 = r13
            r60 = r2
            r61 = r16
            r62 = r7
            r63 = r76
            r64 = r10
            r65 = r8
            r66 = r12
            r67 = r9
            r68 = r1
            r54.<init>(r55, r57, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68)
            r15 = 1823402604(0x6caeea6c, float:1.691681E27)
            r70 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r15, r2, r14)
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            if (r4 == 0) goto L_0x04cd
            r15 = -1013848234(0xffffffffc391e756, float:-291.8073)
            r11.startReplaceableGroup(r15)
            java.lang.String r15 = "195@8636L487"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r15)
            androidx.compose.material.DrawerState r15 = r1.getDrawerState()
            androidx.compose.material.ScaffoldKt$Scaffold$1 r2 = new androidx.compose.material.ScaffoldKt$Scaffold$1
            r2.<init>(r14)
            r71 = r1
            r1 = 100842932(0x602bdb4, float:2.4589654E-35)
            r72 = r7
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r1, r7, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r2 = r12 >> 24
            r2 = r2 & 14
            r7 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r7
            int r7 = r12 << 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r2 = r2 | r7
            int r7 = r12 >> 18
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r7
            int r7 = r13 << 12
            r7 = r7 & r22
            r2 = r2 | r7
            int r7 = r13 << 12
            r7 = r7 & r28
            r2 = r2 | r7
            int r7 = r13 << 12
            r7 = r7 & r32
            r2 = r2 | r7
            int r7 = r13 << 12
            r7 = r7 & r34
            r2 = r2 | r7
            r7 = 234881024(0xe000000, float:1.5777218E-30)
            int r21 = r13 << 12
            r7 = r21 & r7
            r2 = r2 | r7
            r7 = 0
            r54 = r4
            r55 = r0
            r56 = r15
            r57 = r5
            r58 = r3
            r59 = r6
            r60 = r19
            r62 = r17
            r64 = r23
            r66 = r1
            r67 = r11
            r68 = r2
            r69 = r7
            androidx.compose.material.DrawerKt.m1488ModalDrawerGs3lGvM(r54, r55, r56, r57, r58, r59, r60, r62, r64, r66, r67, r68, r69)
            r11.endReplaceableGroup()
            goto L_0x04ea
        L_0x04cd:
            r71 = r1
            r72 = r7
            r1 = -1013847725(0xffffffffc391e953, float:-291.82285)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "208@9145L15"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r12 & 14
            r1 = r1 | 48
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r14.invoke(r0, r11, r1)
            r11.endReplaceableGroup()
        L_0x04ea:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x04f3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04f3:
            r34 = r70
            r28 = r71
            r27 = r0
            r37 = r3
            r35 = r4
            r36 = r5
            r38 = r6
            r31 = r9
            r32 = r10
            r49 = r12
            r50 = r13
            r33 = r16
            r41 = r17
            r39 = r19
            r43 = r23
            r45 = r25
            r47 = r29
            r29 = r72
            r30 = r8
        L_0x0519:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 != 0) goto L_0x0522
            r52 = r11
            goto L_0x0560
        L_0x0522:
            androidx.compose.material.ScaffoldKt$Scaffold$2 r51 = new androidx.compose.material.ScaffoldKt$Scaffold$2
            r0 = r51
            r1 = r27
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = r36
            r52 = r11
            r11 = r37
            r12 = r38
            r13 = r39
            r53 = r15
            r15 = r41
            r17 = r43
            r19 = r45
            r21 = r47
            r23 = r76
            r24 = r78
            r25 = r79
            r26 = r80
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r19, r21, r23, r24, r25, r26)
            r0 = r51
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r53
            r1.updateScope(r0)
        L_0x0560:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m1589Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-MDYNRJg  reason: not valid java name */
    public static final void m1590ScaffoldLayoutMDYNRJg(boolean isFabDocked, int fabPosition, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Function2<? super Composer, ? super Integer, Unit> snackbar, Function2<? super Composer, ? super Integer, Unit> fab, Function2<? super Composer, ? super Integer, Unit> bottomBar, Composer $composer, int $changed) {
        int i;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1401632215);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayout)P(4,3:c#material.FabPosition,6,1,5,2)236@10234L4586,236@10217L4603:Scaffold.kt#jmzs0o");
        int $dirty = $changed;
        if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(isFabDocked) ? 4 : 2;
        } else {
            boolean z = isFabDocked;
        }
        if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed(fabPosition) ? 32 : 16;
        } else {
            int i3 = fabPosition;
        }
        if ((i2 & 896) == 0) {
            $dirty |= $composer2.changedInstance(topBar) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = topBar;
        }
        if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 2048 : 1024;
        } else {
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3 = content;
        }
        if ((57344 & i2) == 0) {
            $dirty |= $composer2.changedInstance(snackbar) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = snackbar;
        }
        if ((458752 & i2) == 0) {
            $dirty |= $composer2.changedInstance(fab) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = fab;
        }
        if ((3670016 & i2) == 0) {
            $dirty |= $composer2.changedInstance(bottomBar) ? 1048576 : 524288;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = bottomBar;
        }
        if ((2995931 & $dirty) != 599186 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1401632215, $dirty, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:227)");
            }
            Object[] keys$iv = {topBar, snackbar, fab, FabPosition.m1510boximpl(fabPosition), Boolean.valueOf(isFabDocked), bottomBar, content};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
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
                value$iv$iv = new ScaffoldKt$ScaffoldLayout$1$1(topBar, snackbar, fab, fabPosition, isFabDocked, bottomBar, $dirty, content);
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
        endRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayout$2(isFabDocked, fabPosition, topBar, content, snackbar, fab, bottomBar, $changed));
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
