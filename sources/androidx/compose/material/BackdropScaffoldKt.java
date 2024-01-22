package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aõ\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ah\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003ø\u0001\u0000¢\u0006\u0002\u0010/\u001a3\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m5986constructorimpl((float) 20);

    public static final BackdropScaffoldState rememberBackdropScaffoldState(BackdropValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> confirmStateChange, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-862178912);
        ComposerKt.sourceInformation($composer, "C(rememberBackdropScaffoldState)P(2)171@6447L32,173@6518L538:BackdropScaffold.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super BackdropValue, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 4) != 0) {
            confirmStateChange2 = BackdropScaffoldKt$rememberBackdropScaffoldState$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new SnackbarHostState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, $changed, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:167)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.rememberSaveable(new Object[]{animationSpec2, confirmStateChange2, snackbarHostState}, BackdropScaffoldState.Companion.Saver(animationSpec2, confirmStateChange2, snackbarHostState), (String) null, new BackdropScaffoldKt$rememberBackdropScaffoldState$3(initialValue, animationSpec2, confirmStateChange2, snackbarHostState), $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return backdropScaffoldState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01a9, code lost:
        if (r9.changed(r68) != false) goto L_0x01b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0597  */
    /* renamed from: BackdropScaffold-BZszfkY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1376BackdropScaffoldBZszfkY(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.ui.Modifier r59, androidx.compose.material.BackdropScaffoldState r60, boolean r61, float r62, float r63, boolean r64, boolean r65, long r66, long r68, androidx.compose.ui.graphics.Shape r70, float r71, long r72, long r74, long r76, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, androidx.compose.runtime.Composer r79, int r80, int r81, int r82) {
        /*
            r15 = r56
            r13 = r57
            r14 = r58
            r11 = r80
            r12 = r81
            r10 = r82
            java.lang.String r0 = "appBar"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "backLayerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "frontLayerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1397420093(0x534af03d, float:8.7161392E11)
            r1 = r79
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BackdropScaffold)P(!1,2,5,12,15,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)260@11766L40,266@12093L6,267@12144L41,268@12241L15,270@12387L6,271@12439L42,272@12542L20,*275@12690L7,276@12764L7,288@13147L100,293@13271L3282:BackdropScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r80
            r2 = r81
            r3 = r10 & 1
            r5 = 2
            if (r3 == 0) goto L_0x0035
            r1 = r1 | 6
            goto L_0x0043
        L_0x0035:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x0043
            boolean r3 = r9.changedInstance(r15)
            if (r3 == 0) goto L_0x0041
            r3 = 4
            goto L_0x0042
        L_0x0041:
            r3 = r5
        L_0x0042:
            r1 = r1 | r3
        L_0x0043:
            r3 = r10 & 2
            r6 = 32
            if (r3 == 0) goto L_0x004c
            r1 = r1 | 48
            goto L_0x005b
        L_0x004c:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x005b
            boolean r3 = r9.changedInstance(r13)
            if (r3 == 0) goto L_0x0058
            r3 = r6
            goto L_0x005a
        L_0x0058:
            r3 = 16
        L_0x005a:
            r1 = r1 | r3
        L_0x005b:
            r3 = r10 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0064
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0074
        L_0x0064:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0074
            boolean r3 = r9.changedInstance(r14)
            if (r3 == 0) goto L_0x0071
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0073
        L_0x0071:
            r3 = r16
        L_0x0073:
            r1 = r1 | r3
        L_0x0074:
            r3 = r10 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0081
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r4 = r59
            goto L_0x0097
        L_0x0081:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0095
            r4 = r59
            boolean r19 = r9.changed((java.lang.Object) r4)
            if (r19 == 0) goto L_0x0090
            r19 = r17
            goto L_0x0092
        L_0x0090:
            r19 = r18
        L_0x0092:
            r1 = r1 | r19
            goto L_0x0097
        L_0x0095:
            r4 = r59
        L_0x0097:
            r19 = 57344(0xe000, float:8.0356E-41)
            r19 = r11 & r19
            r20 = 8192(0x2000, float:1.14794E-41)
            r21 = 16384(0x4000, float:2.2959E-41)
            if (r19 != 0) goto L_0x00b8
            r19 = r10 & 16
            if (r19 != 0) goto L_0x00b1
            r8 = r60
            boolean r22 = r9.changed((java.lang.Object) r8)
            if (r22 == 0) goto L_0x00b3
            r22 = r21
            goto L_0x00b5
        L_0x00b1:
            r8 = r60
        L_0x00b3:
            r22 = r20
        L_0x00b5:
            r1 = r1 | r22
            goto L_0x00ba
        L_0x00b8:
            r8 = r60
        L_0x00ba:
            r22 = r10 & 32
            r23 = 131072(0x20000, float:1.83671E-40)
            r24 = 65536(0x10000, float:9.18355E-41)
            if (r22 == 0) goto L_0x00c9
            r25 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r25
            r0 = r61
            goto L_0x00e1
        L_0x00c9:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r11 & r25
            if (r25 != 0) goto L_0x00df
            r0 = r61
            boolean r26 = r9.changed((boolean) r0)
            if (r26 == 0) goto L_0x00da
            r26 = r23
            goto L_0x00dc
        L_0x00da:
            r26 = r24
        L_0x00dc:
            r1 = r1 | r26
            goto L_0x00e1
        L_0x00df:
            r0 = r61
        L_0x00e1:
            r26 = r10 & 64
            if (r26 == 0) goto L_0x00ec
            r27 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r27
            r7 = r62
            goto L_0x0104
        L_0x00ec:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r11 & r27
            if (r27 != 0) goto L_0x0102
            r7 = r62
            boolean r28 = r9.changed((float) r7)
            if (r28 == 0) goto L_0x00fd
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ff
        L_0x00fd:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00ff:
            r1 = r1 | r28
            goto L_0x0104
        L_0x0102:
            r7 = r62
        L_0x0104:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0111
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r28
            r28 = r7
            r7 = r63
            goto L_0x012d
        L_0x0111:
            r28 = 29360128(0x1c00000, float:7.052966E-38)
            r28 = r11 & r28
            if (r28 != 0) goto L_0x0129
            r28 = r7
            r7 = r63
            boolean r29 = r9.changed((float) r7)
            if (r29 == 0) goto L_0x0124
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0126
        L_0x0124:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x0126:
            r1 = r1 | r29
            goto L_0x012d
        L_0x0129:
            r28 = r7
            r7 = r63
        L_0x012d:
            r7 = r10 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x013a
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r29
            r29 = r7
            r7 = r64
            goto L_0x0156
        L_0x013a:
            r29 = 234881024(0xe000000, float:1.5777218E-30)
            r29 = r11 & r29
            if (r29 != 0) goto L_0x0152
            r29 = r7
            r7 = r64
            boolean r30 = r9.changed((boolean) r7)
            if (r30 == 0) goto L_0x014d
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x014f
        L_0x014d:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x014f:
            r1 = r1 | r30
            goto L_0x0156
        L_0x0152:
            r29 = r7
            r7 = r64
        L_0x0156:
            r7 = r10 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x0165
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r30
            r31 = r1
            r30 = r7
            r7 = r65
            goto L_0x0183
        L_0x0165:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r11 & r30
            if (r30 != 0) goto L_0x017d
            r30 = r7
            r7 = r65
            boolean r31 = r9.changed((boolean) r7)
            if (r31 == 0) goto L_0x0178
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x017a
        L_0x0178:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x017a:
            r1 = r1 | r31
            goto L_0x0181
        L_0x017d:
            r30 = r7
            r7 = r65
        L_0x0181:
            r31 = r1
        L_0x0183:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x0199
            r1 = r10 & 1024(0x400, float:1.435E-42)
            if (r1 != 0) goto L_0x0195
            r7 = r66
            boolean r1 = r9.changed((long) r7)
            if (r1 == 0) goto L_0x0197
            r5 = 4
            goto L_0x0197
        L_0x0195:
            r7 = r66
        L_0x0197:
            r2 = r2 | r5
            goto L_0x019b
        L_0x0199:
            r7 = r66
        L_0x019b:
            r1 = r12 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x01b2
            r1 = r10 & 2048(0x800, float:2.87E-42)
            if (r1 != 0) goto L_0x01ac
            r7 = r68
            boolean r1 = r9.changed((long) r7)
            if (r1 == 0) goto L_0x01ae
            goto L_0x01b0
        L_0x01ac:
            r7 = r68
        L_0x01ae:
            r6 = 16
        L_0x01b0:
            r2 = r2 | r6
            goto L_0x01b4
        L_0x01b2:
            r7 = r68
        L_0x01b4:
            r1 = r12 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x01cc
            r1 = r10 & 4096(0x1000, float:5.74E-42)
            if (r1 != 0) goto L_0x01c7
            r6 = r70
            boolean r1 = r9.changed((java.lang.Object) r6)
            if (r1 == 0) goto L_0x01c9
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x01c9
        L_0x01c7:
            r6 = r70
        L_0x01c9:
            r2 = r2 | r16
            goto L_0x01ce
        L_0x01cc:
            r6 = r70
        L_0x01ce:
            r5 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01d7
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r1 = r71
            goto L_0x01eb
        L_0x01d7:
            r1 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x01e9
            r1 = r71
            boolean r16 = r9.changed((float) r1)
            if (r16 == 0) goto L_0x01e4
            goto L_0x01e6
        L_0x01e4:
            r17 = r18
        L_0x01e6:
            r2 = r2 | r17
            goto L_0x01eb
        L_0x01e9:
            r1 = r71
        L_0x01eb:
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x0206
            r0 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r0 != 0) goto L_0x0201
            r7 = r72
            boolean r0 = r9.changed((long) r7)
            if (r0 == 0) goto L_0x0203
            r20 = r21
            goto L_0x0203
        L_0x0201:
            r7 = r72
        L_0x0203:
            r2 = r2 | r20
            goto L_0x0208
        L_0x0206:
            r7 = r72
        L_0x0208:
            r0 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r12
            r16 = 32768(0x8000, float:4.5918E-41)
            if (r0 != 0) goto L_0x0225
            r0 = r10 & r16
            if (r0 != 0) goto L_0x021f
            r7 = r74
            boolean r0 = r9.changed((long) r7)
            if (r0 == 0) goto L_0x0221
            r0 = r23
            goto L_0x0223
        L_0x021f:
            r7 = r74
        L_0x0221:
            r0 = r24
        L_0x0223:
            r2 = r2 | r0
            goto L_0x0227
        L_0x0225:
            r7 = r74
        L_0x0227:
            r0 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r12
            if (r0 != 0) goto L_0x0241
            r0 = r10 & r24
            if (r0 != 0) goto L_0x023b
            r7 = r76
            boolean r0 = r9.changed((long) r7)
            if (r0 == 0) goto L_0x023d
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023f
        L_0x023b:
            r7 = r76
        L_0x023d:
            r0 = 524288(0x80000, float:7.34684E-40)
        L_0x023f:
            r2 = r2 | r0
            goto L_0x0243
        L_0x0241:
            r7 = r76
        L_0x0243:
            r0 = r10 & r23
            if (r0 == 0) goto L_0x024e
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r17
            r7 = r78
            goto L_0x0265
        L_0x024e:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x0263
            r7 = r78
            boolean r8 = r9.changedInstance(r7)
            if (r8 == 0) goto L_0x025f
            r8 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0261
        L_0x025f:
            r8 = 4194304(0x400000, float:5.877472E-39)
        L_0x0261:
            r2 = r2 | r8
            goto L_0x0265
        L_0x0263:
            r7 = r78
        L_0x0265:
            r8 = r2
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r31 & r2
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r1) goto L_0x02a7
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r8
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r2) goto L_0x02a7
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x0280
            goto L_0x02a7
        L_0x0280:
            r9.skipToGroupEnd()
            r28 = r60
            r29 = r61
            r30 = r62
            r32 = r64
            r33 = r65
            r34 = r66
            r39 = r68
            r42 = r71
            r43 = r72
            r45 = r74
            r47 = r76
            r27 = r4
            r41 = r6
            r49 = r7
            r36 = r8
            r37 = r31
            r31 = r63
            goto L_0x05ae
        L_0x02a7:
            r9.startDefaults()
            r1 = r11 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x032c
            boolean r1 = r9.getDefaultsInvalid()
            if (r1 == 0) goto L_0x02b9
            goto L_0x032c
        L_0x02b9:
            r9.skipToGroupEnd()
            r0 = r10 & 16
            if (r0 == 0) goto L_0x02c2
            r31 = r31 & r17
        L_0x02c2:
            r0 = r10 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x02c8
            r8 = r8 & -15
        L_0x02c8:
            r0 = r10 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x02ce
            r8 = r8 & -113(0xffffffffffffff8f, float:NaN)
        L_0x02ce:
            r0 = r10 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x02d4
            r8 = r8 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02d4:
            r0 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x02da
            r8 = r8 & r17
        L_0x02da:
            r0 = r10 & r16
            if (r0 == 0) goto L_0x02e2
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = r8 & r0
        L_0x02e2:
            r0 = r10 & r24
            if (r0 == 0) goto L_0x030b
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r8
            r1 = r61
            r2 = r62
            r3 = r63
            r5 = r64
            r39 = r68
            r42 = r71
            r43 = r72
            r45 = r74
            r47 = r76
            r10 = r0
            r41 = r6
            r49 = r7
            r11 = r31
            r0 = r60
            r6 = r65
            r7 = r66
            goto L_0x0462
        L_0x030b:
            r0 = r60
            r1 = r61
            r2 = r62
            r3 = r63
            r5 = r64
            r39 = r68
            r42 = r71
            r43 = r72
            r45 = r74
            r47 = r76
            r41 = r6
            r49 = r7
            r10 = r8
            r11 = r31
            r6 = r65
            r7 = r66
            goto L_0x0462
        L_0x032c:
            if (r3 == 0) goto L_0x0335
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r18 = r1
            goto L_0x0337
        L_0x0335:
            r18 = r4
        L_0x0337:
            r1 = r10 & 16
            if (r1 == 0) goto L_0x0358
            androidx.compose.material.BackdropValue r1 = androidx.compose.material.BackdropValue.Concealed
            r2 = 0
            r3 = 0
            r4 = 0
            r19 = 6
            r20 = 14
            r21 = r5
            r5 = r9
            r6 = r19
            r19 = r28
            r23 = r29
            r27 = r30
            r7 = r20
            androidx.compose.material.BackdropScaffoldState r1 = rememberBackdropScaffoldState(r1, r2, r3, r4, r5, r6, r7)
            r31 = r31 & r17
            goto L_0x0362
        L_0x0358:
            r21 = r5
            r19 = r28
            r23 = r29
            r27 = r30
            r1 = r60
        L_0x0362:
            if (r22 == 0) goto L_0x0366
            r2 = 1
            goto L_0x0368
        L_0x0366:
            r2 = r61
        L_0x0368:
            if (r26 == 0) goto L_0x0371
            androidx.compose.material.BackdropScaffoldDefaults r3 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r3 = r3.m1375getPeekHeightD9Ej5fM()
            goto L_0x0373
        L_0x0371:
            r3 = r62
        L_0x0373:
            if (r19 == 0) goto L_0x037c
            androidx.compose.material.BackdropScaffoldDefaults r4 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r4 = r4.m1374getHeaderHeightD9Ej5fM()
            goto L_0x037e
        L_0x037c:
            r4 = r63
        L_0x037e:
            if (r23 == 0) goto L_0x0382
            r5 = 1
            goto L_0x0384
        L_0x0382:
            r5 = r64
        L_0x0384:
            if (r27 == 0) goto L_0x0388
            r6 = 1
            goto L_0x038a
        L_0x0388:
            r6 = r65
        L_0x038a:
            r7 = r10 & 1024(0x400, float:1.435E-42)
            r59 = r1
            r1 = 6
            if (r7 == 0) goto L_0x03a4
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r7 = r7.getColors(r9, r1)
            long r19 = r7.m1445getPrimary0d7_KjU()
            r8 = r8 & -15
            r54 = r19
            r19 = r8
            r7 = r54
            goto L_0x03a8
        L_0x03a4:
            r19 = r8
            r7 = r66
        L_0x03a8:
            r1 = r10 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x03b7
            r1 = r19 & 14
            long r22 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r7, r9, r1)
            r19 = r19 & -113(0xffffffffffffff8f, float:NaN)
            r1 = r19
            goto L_0x03bb
        L_0x03b7:
            r22 = r68
            r1 = r19
        L_0x03bb:
            r61 = r2
            r2 = r10 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x03cd
            androidx.compose.material.BackdropScaffoldDefaults r2 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            r62 = r3
            r3 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getFrontLayerShape(r9, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x03d1
        L_0x03cd:
            r62 = r3
            r2 = r70
        L_0x03d1:
            if (r21 == 0) goto L_0x03da
            androidx.compose.material.BackdropScaffoldDefaults r3 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r3 = r3.m1373getFrontLayerElevationD9Ej5fM()
            goto L_0x03dc
        L_0x03da:
            r3 = r71
        L_0x03dc:
            r63 = r2
            r2 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x03f2
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r64 = r3
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r9, r3)
            long r2 = r2.m1449getSurface0d7_KjU()
            r1 = r1 & r17
            goto L_0x03f6
        L_0x03f2:
            r64 = r3
            r2 = r72
        L_0x03f6:
            r16 = r10 & r16
            if (r16 == 0) goto L_0x0409
            int r16 = r1 >> 12
            r79 = r4
            r4 = r16 & 14
            long r16 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r2, r9, r4)
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            goto L_0x040d
        L_0x0409:
            r79 = r4
            r16 = r74
        L_0x040d:
            r4 = r10 & r24
            if (r4 == 0) goto L_0x041f
            androidx.compose.material.BackdropScaffoldDefaults r4 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            r19 = r2
            r2 = 6
            long r2 = r4.getFrontLayerScrimColor(r9, r2)
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r4
            goto L_0x0423
        L_0x041f:
            r19 = r2
            r2 = r76
        L_0x0423:
            if (r0 == 0) goto L_0x0447
            androidx.compose.material.ComposableSingletons$BackdropScaffoldKt r0 = androidx.compose.material.ComposableSingletons$BackdropScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r0 = r0.m1469getLambda1$material_release()
            r41 = r63
            r42 = r64
            r49 = r0
            r10 = r1
            r47 = r2
            r45 = r16
            r4 = r18
            r43 = r19
            r39 = r22
            r11 = r31
            r0 = r59
            r1 = r61
            r2 = r62
            r3 = r79
            goto L_0x0462
        L_0x0447:
            r0 = r59
            r41 = r63
            r42 = r64
            r49 = r78
            r10 = r1
            r47 = r2
            r45 = r16
            r4 = r18
            r43 = r19
            r39 = r22
            r11 = r31
            r1 = r61
            r2 = r62
            r3 = r79
        L_0x0462:
            r9.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0473
            java.lang.String r12 = "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)"
            r13 = 1397420093(0x534af03d, float:8.7161392E11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r11, r10, r12)
        L_0x0473:
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 0
            r16 = 0
            r59 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r13, r14)
            java.lang.Object r13 = r9.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r12 = r13
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            r13 = 0
            float r12 = r12.m5967toPx0680j_4(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r14 = 0
            r16 = 0
            r59 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r14, r15)
            java.lang.Object r14 = r9.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r13 = r14
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            r14 = 0
            float r13 = r13.m5967toPx0680j_4(r3)
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1 r14 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
            r59 = r14
            r60 = r5
            r61 = r0
            r62 = r56
            r63 = r57
            r64 = r11
            r59.<init>(r60, r61, r62, r63, r64)
            r15 = 1744778315(0x67ff344b, float:2.4103362E24)
            r71 = r5
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r15, r5, r14)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            java.lang.Float r15 = java.lang.Float.valueOf(r13)
            r16 = 0
            r17 = 0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r5)
            boolean r5 = r9.changed((java.lang.Object) r15)
            r60 = r9
            r18 = 0
            r61 = r15
            java.lang.Object r15 = r60.rememberedValue()
            r19 = 0
            if (r5 != 0) goto L_0x050c
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r62 = r5
            java.lang.Object r5 = r20.getEmpty()
            if (r15 != r5) goto L_0x0505
            goto L_0x050e
        L_0x0505:
            r63 = r15
            r5 = r63
            r15 = r60
            goto L_0x0521
        L_0x050c:
            r62 = r5
        L_0x050e:
            r5 = 0
            r63 = r5
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 r5 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
            r5.<init>(r13)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r63 = r15
            r15 = r60
            r15.updateRememberedValue(r5)
        L_0x0521:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r19 = r5
            r50 = 0
            r51 = 0
            r52 = 0
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1 r15 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
            r16 = r15
            r17 = r4
            r18 = r14
            r20 = r13
            r21 = r6
            r22 = r1
            r23 = r0
            r24 = r12
            r25 = r11
            r26 = r41
            r27 = r43
            r29 = r45
            r31 = r42
            r32 = r10
            r33 = r3
            r34 = r2
            r35 = r58
            r36 = r47
            r38 = r49
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r31, r32, r33, r34, r35, r36, r38)
            r72 = r0
            r0 = -1049909631(0xffffffffc16ba681, float:-14.72815)
            r73 = r1
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r0, r1, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r10 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r15 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r15
            int r15 = r10 << 6
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r15
            r15 = 51
            r16 = 0
            r59 = r16
            r60 = r50
            r61 = r7
            r63 = r39
            r65 = r51
            r66 = r52
            r67 = r0
            r68 = r9
            r69 = r1
            r70 = r15
            androidx.compose.material.SurfaceKt.m1620SurfaceFjzlyU(r59, r60, r61, r63, r65, r66, r67, r68, r69, r70)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x059a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x059a:
            r32 = r71
            r28 = r72
            r29 = r73
            r30 = r2
            r31 = r3
            r27 = r4
            r33 = r6
            r34 = r7
            r36 = r10
            r37 = r11
        L_0x05ae:
            androidx.compose.runtime.ScopeUpdateScope r15 = r9.endRestartGroup()
            if (r15 != 0) goto L_0x05b7
            r50 = r9
            goto L_0x05f5
        L_0x05b7:
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2 r38 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
            r0 = r38
            r1 = r56
            r2 = r57
            r3 = r58
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r50 = r9
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r39
            r53 = r15
            r15 = r41
            r16 = r42
            r17 = r43
            r19 = r45
            r21 = r47
            r23 = r49
            r24 = r80
            r25 = r81
            r26 = r82
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r19, r21, r23, r24, r25, r26)
            r0 = r38
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r53
            r1.updateScope(r0)
        L_0x05f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.m1376BackdropScaffoldBZszfkY(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material.BackdropScaffoldState, boolean, float, float, boolean, boolean, long, long, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m1377Scrim3JVO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        Modifier dismissModifier;
        long j = color;
        Function0<Unit> function0 = onDismiss;
        boolean z = visible;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)388@16708L121,401@17118L62,397@17009L171:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(z) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92141505, $dirty2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:382)");
            }
            if (color != Color.Companion.m3200getUnspecified0d7_KjU()) {
                State alpha$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (Function1) null, $composer2, 48, 12);
                $composer2.startReplaceableGroup(1010547004);
                ComposerKt.sourceInformation($composer2, "393@16915L37");
                if (z) {
                    Modifier modifier = Modifier.Companion;
                    Unit unit = Unit.INSTANCE;
                    int i2 = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed((Object) function0);
                    Composer $this$cache$iv$iv = $composer2;
                    Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
                        Object obj = value$iv$iv;
                        value$iv$iv = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, (Continuation<? super BackdropScaffoldKt$Scrim$dismissModifier$1$1>) null);
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Composer composer = $this$cache$iv$iv;
                        Object obj2 = value$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    dismissModifier = SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv);
                } else {
                    dismissModifier = Modifier.Companion;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(dismissModifier);
                Object r2 = Color.m3154boximpl(color);
                int i3 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed(r2) | $composer2.changed((Object) alpha$delegate);
                Composer $this$cache$iv$iv2 = $composer2;
                Modifier modifier2 = dismissModifier;
                Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                if (!invalid$iv$iv2) {
                    Color color2 = r2;
                    if (value$iv$iv2 != Composer.Companion.getEmpty()) {
                        Object obj3 = value$iv$iv2;
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
                    }
                } else {
                    Object key1$iv = r2;
                }
                Object obj4 = value$iv$iv2;
                value$iv$iv2 = new BackdropScaffoldKt$Scrim$1$1(j, alpha$delegate);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i4 = $dirty2;
            Composer composer2 = $composer2;
            return;
        }
        int i5 = $dirty2;
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new BackdropScaffoldKt$Scrim$2(color, onDismiss, visible, $changed));
    }

    /* access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$4(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void BackLayerTransition(BackdropValue target, Function2<? super Composer, ? super Integer, Unit> appBar, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Composer $composer2;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        BackdropValue backdropValue = target;
        Function2<? super Composer, ? super Integer, Unit> function23 = appBar;
        Function2<? super Composer, ? super Integer, Unit> function24 = content;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(-950970976);
        ComposerKt.sourceInformation($composer3, "C(BackLayerTransition)P(2)421@17840L112,*424@18002L7,429@18176L486:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changed((Object) backdropValue) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer3.changedInstance(function24) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, $dirty2, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:414)");
            }
            State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(backdropValue == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (Function1) null, $composer3, 48, 12);
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float animationSlideOffset = ((Density) consume).m5967toPx0680j_4(AnimationSlideOffset);
            float f = (float) 1;
            float appBarFloat = RangesKt.coerceIn(BackLayerTransition$lambda$7(animationProgress$delegate) - f, 0.0f, 1.0f);
            float contentFloat = RangesKt.coerceIn(f - BackLayerTransition$lambda$7(animationProgress$delegate), 0.0f, 1.0f);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            State state = animationProgress$delegate;
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment alignment = contentAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            float contentFloat2 = contentFloat;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            function3.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Composer $composer$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i2 = ((0 >> 6) & 112) | 6;
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            int i3 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer4 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, -1538629162, "C430@18190L226,438@18425L231:BackdropScaffold.kt#jmzs0o");
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Modifier modifier$iv = GraphicsLayerModifierKt.m3310graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(Modifier.Companion, appBarFloat), 0.0f, 0.0f, appBarFloat, 0.0f, (f - appBarFloat) * animationSlideOffset, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131051, (Object) null);
            $composer4.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            float f2 = appBarFloat;
            int i4 = $changed$iv$iv$iv;
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            Alignment alignment2 = contentAlignment$iv2;
            $composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density$iv$iv2 = (Density) consume5;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume6;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume7;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer4);
            Function0<ComposeUiNode> function02 = constructor2;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer4.enableReusing();
            Density density2 = density$iv$iv2;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
            function34.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer4.startReplaceableGroup(2058660585);
            int i5 = ($changed$iv$iv$iv2 >> 9) & 14;
            Composer $composer$iv2 = $composer4;
            int i6 = $changed$iv$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i7 = ((0 >> 6) & 112) | 6;
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
            LayoutDirection layoutDirection2 = layoutDirection$iv$iv2;
            Composer $composer5 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer5, -481855289, "C436@18398L8:BackdropScaffold.kt#jmzs0o");
            function2 = appBar;
            function2.invoke($composer5, Integer.valueOf(($dirty2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer4.endReplaceableGroup();
            $composer4.endNode();
            $composer4.endReplaceableGroup();
            $composer4.endReplaceableGroup();
            float contentFloat3 = contentFloat2;
            Modifier modifier$iv2 = GraphicsLayerModifierKt.m3310graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(Modifier.Companion, contentFloat3), 0.0f, 0.0f, contentFloat3, 0.0f, (f - contentFloat3) * (-animationSlideOffset), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131051, (Object) null);
            $composer4.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            float f3 = animationSlideOffset;
            $composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density$iv$iv3 = (Density) consume8;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume9;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume10 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume10;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
            Modifier modifier2 = modifier$iv2;
            int $changed$iv$iv$iv3 = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Alignment alignment3 = contentAlignment$iv3;
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
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer4.startReplaceableGroup(2058660585);
            int i8 = ($changed$iv$iv$iv3 >> 9) & 14;
            Composer $composer$iv3 = $composer4;
            int i9 = $changed$iv$iv$iv3;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            Density density3 = density$iv$iv3;
            Composer $composer6 = $composer$iv3;
            ComposerKt.sourceInformationMarkerStart($composer6, -481855050, "C444@18637L9:BackdropScaffold.kt#jmzs0o");
            function22 = content;
            function22.invoke($composer6, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer4.endReplaceableGroup();
            $composer4.endNode();
            $composer4.endReplaceableGroup();
            $composer4.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
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
            function2 = function23;
            function22 = function24;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            BackdropValue backdropValue2 = target;
            int i11 = $changed;
            return;
        }
        endRestartGroup.updateScope(new BackdropScaffoldKt$BackLayerTransition$2(target, function2, function22, $changed));
    }

    private static final float BackLayerTransition$lambda$7(State<Float> $animationProgress$delegate) {
        return ((Number) $animationProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void BackdropStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> backLayer, Function1<? super Constraints, Constraints> calculateBackLayerConstraints, Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> frontLayer, Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation($composer2, "C(BackdropStack)P(3)457@18967L890,457@18940L917:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(backLayer) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(calculateBackLayerConstraints) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(frontLayer) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, $dirty, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:451)");
            }
            int i = (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896);
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) backLayer) | $composer2.changed((Object) calculateBackLayerConstraints) | $composer2.changed((Object) frontLayer);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function2) new BackdropScaffoldKt$BackdropStack$1$1(backLayer, calculateBackLayerConstraints, frontLayer, $dirty);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) value$iv$iv, $composer2, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BackdropScaffoldKt$BackdropStack$2(modifier, backLayer, calculateBackLayerConstraints, frontLayer, $changed));
        }
    }
}
