package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aQ\u0010\u001a\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010!\u001am\u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ao\u0010%\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0019\u001ac\u0010'\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010(\u001a\u00020\u000e2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0001\u0010+\u001a\u00020\b2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\u0006\u0010-\u001a\u00020 2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c¢\u0006\u0002\b\u00162\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u00101\u001a\u00020\f2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H\u0007¢\u0006\u0002\u00106\u001ao\u00107\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0019\u001a=\u00109\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010:\u001aA\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020 2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010?\u001a\u00020\u000eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a \u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u0002H\u0002\u001a+\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020H2\u0014\b\u0002\u0010I\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020 0\u0014H\u0007¢\u0006\u0002\u0010J\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006K"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "drawerState", "Landroidx/compose/material3/DrawerState;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "DrawerSheet-vywBR7E", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationDrawer.kt */
public final class NavigationDrawerKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(256, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float DrawerVelocityThreshold = Dp.m5986constructorimpl((float) 400);
    /* access modifiers changed from: private */
    public static final float MinimumDrawerWidth = Dp.m5986constructorimpl((float) 240);

    @ExperimentalMaterial3Api
    public static final DrawerState rememberDrawerState(DrawerValue initialValue, Function1<? super DrawerValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Function0 value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(2098699222);
        ComposerKt.sourceInformation($composer, "C(rememberDrawerState)P(1)229@8113L61,229@8049L125:NavigationDrawer.kt#uh7d8r");
        Function1<? super DrawerValue, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 2) != 0) {
            confirmStateChange2 = NavigationDrawerKt$rememberDrawerState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, $changed, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:225)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.Companion.Saver(confirmStateChange2);
        int i2 = ($changed & 14) | ($changed & 112);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) initialValue) | $composer.changed((Object) confirmStateChange2);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new NavigationDrawerKt$rememberDrawerState$2$1(initialValue, confirmStateChange2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return drawerState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0627  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0635  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0702  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x070e  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0712  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x077f  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0789  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x080b  */
    /* JADX WARNING: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e2  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: ModalNavigationDrawer-FHprtrg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2009ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, androidx.compose.ui.Modifier r69, androidx.compose.material3.DrawerState r70, boolean r71, long r72, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, androidx.compose.runtime.Composer r75, int r76, int r77) {
        /*
            r10 = r68
            r11 = r74
            r12 = r76
            java.lang.String r0 = "drawerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1169303680(0xffffffffba4dd780, float:-7.8522414E-4)
            r1 = r75
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(ModalNavigationDrawer)P(1,4,2,3,5:c#ui.graphics.Color)258@9353L39,260@9470L10,263@9538L24,264@9588L33,*265@9660L7,269@9864L7,270@9899L1722:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r0 = r76
            r1 = r77 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0028
            r0 = r0 | 6
            goto L_0x0036
        L_0x0028:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x0036
            boolean r1 = r13.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x0034
            r1 = 4
            goto L_0x0035
        L_0x0034:
            r1 = r2
        L_0x0035:
            r0 = r0 | r1
        L_0x0036:
            r1 = r77 & 2
            if (r1 == 0) goto L_0x003f
            r0 = r0 | 48
            r4 = r69
            goto L_0x0054
        L_0x003f:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0052
            r4 = r69
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004e
            r5 = 32
            goto L_0x0050
        L_0x004e:
            r5 = 16
        L_0x0050:
            r0 = r0 | r5
            goto L_0x0054
        L_0x0052:
            r4 = r69
        L_0x0054:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006d
            r5 = r77 & 4
            if (r5 != 0) goto L_0x0067
            r5 = r70
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0069
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0067:
            r5 = r70
        L_0x0069:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r0 = r0 | r6
            goto L_0x006f
        L_0x006d:
            r5 = r70
        L_0x006f:
            r6 = r77 & 8
            if (r6 == 0) goto L_0x0078
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r7 = r71
            goto L_0x008d
        L_0x0078:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008b
            r7 = r71
            boolean r8 = r13.changed((boolean) r7)
            if (r8 == 0) goto L_0x0087
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r0 = r0 | r8
            goto L_0x008d
        L_0x008b:
            r7 = r71
        L_0x008d:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r12
            if (r8 != 0) goto L_0x00a8
            r8 = r77 & 16
            if (r8 != 0) goto L_0x00a2
            r8 = r72
            boolean r14 = r13.changed((long) r8)
            if (r14 == 0) goto L_0x00a4
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a2:
            r8 = r72
        L_0x00a4:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r0 = r0 | r14
            goto L_0x00aa
        L_0x00a8:
            r8 = r72
        L_0x00aa:
            r14 = r77 & 32
            if (r14 == 0) goto L_0x00b2
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00b0:
            r0 = r0 | r14
            goto L_0x00c3
        L_0x00b2:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00c3
            boolean r14 = r13.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x00c0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00c0:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b0
        L_0x00c3:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r0
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00e2
            boolean r14 = r13.getSkipping()
            if (r14 != 0) goto L_0x00d3
            goto L_0x00e2
        L_0x00d3:
            r13.skipToGroupEnd()
            r16 = r4
            r12 = r7
            r32 = r8
            r3 = r10
            r55 = r13
            r13 = r0
            r10 = r5
            goto L_0x0804
        L_0x00e2:
            r13.startDefaults()
            r14 = r12 & 1
            r15 = 0
            r3 = 6
            if (r14 == 0) goto L_0x0106
            boolean r14 = r13.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00f2
            goto L_0x0106
        L_0x00f2:
            r13.skipToGroupEnd()
            r1 = r77 & 4
            if (r1 == 0) goto L_0x00fb
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00fb:
            r1 = r77 & 16
            if (r1 == 0) goto L_0x0103
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = r0 & r1
        L_0x0103:
            r1 = r4
            r4 = r5
            goto L_0x012f
        L_0x0106:
            if (r1 == 0) goto L_0x010d
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x010e
        L_0x010d:
            r1 = r4
        L_0x010e:
            r4 = r77 & 4
            if (r4 == 0) goto L_0x011b
            androidx.compose.material3.DrawerValue r4 = androidx.compose.material3.DrawerValue.Closed
            androidx.compose.material3.DrawerState r4 = rememberDrawerState(r4, r15, r13, r3, r2)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x011c
        L_0x011b:
            r4 = r5
        L_0x011c:
            if (r6 == 0) goto L_0x0120
            r5 = 1
            r7 = r5
        L_0x0120:
            r5 = r77 & 16
            if (r5 == 0) goto L_0x012f
            androidx.compose.material3.DrawerDefaults r5 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r5 = r5.getScrimColor(r13, r3)
            r8 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = r0 & r8
            r8 = r5
        L_0x012f:
            r13.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0141
            r5 = -1169303680(0xffffffffba4dd780, float:-7.8522414E-4)
            r6 = -1
            java.lang.String r14 = "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:255)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r0, r6, r14)
        L_0x0141:
            r5 = 0
            r6 = r5
            r14 = 0
            r15 = 773894976(0x2e20b340, float:3.6538994E-11)
            r13.startReplaceableGroup(r15)
            java.lang.String r15 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r15)
            r15 = r13
            r16 = r5
            r17 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            r5 = 0
            r70 = r13
            r18 = 0
            java.lang.Object r2 = r70.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r20.getEmpty()
            if (r2 != r3) goto L_0x0193
            r3 = 0
            r20 = 0
            kotlin.coroutines.EmptyCoroutineContext r20 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r71 = r2
            r2 = r20
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r15)
            r72 = r3
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r3.<init>(r2)
            r2 = r3
            r3 = r70
            r3.updateRememberedValue(r2)
            goto L_0x0197
        L_0x0193:
            r3 = r70
            r71 = r2
        L_0x0197:
            r13.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r3 = r2.getCoroutineScope()
            r13.endReplaceableGroup()
            r2 = r3
            androidx.compose.material3.Strings$Companion r3 = androidx.compose.material3.Strings.Companion
            int r3 = r3.m2086getNavigationMenuadMyvUU()
            r5 = 6
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m2089getStringNWtq28(r3, r13, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 0
            r14 = 0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            r70 = r6
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r15, r6)
            java.lang.Object r16 = r13.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r5 = r16
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            r14 = 0
            androidx.compose.material3.tokens.NavigationDrawerTokens r16 = androidx.compose.material3.tokens.NavigationDrawerTokens.INSTANCE
            float r15 = r16.m2525getContainerWidthD9Ej5fM()
            float r5 = r5.m5967toPx0680j_4(r15)
            float r5 = -r5
            r14 = 0
            r15 = 2
            kotlin.Pair[] r12 = new kotlin.Pair[r15]
            java.lang.Float r15 = java.lang.Float.valueOf(r5)
            androidx.compose.material3.DrawerValue r10 = androidx.compose.material3.DrawerValue.Closed
            kotlin.Pair r10 = kotlin.TuplesKt.to(r15, r10)
            r15 = 0
            r12[r15] = r10
            java.lang.Float r10 = java.lang.Float.valueOf(r14)
            androidx.compose.material3.DrawerValue r15 = androidx.compose.material3.DrawerValue.Open
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r15)
            r15 = 1
            r12[r15] = r10
            java.util.Map r10 = kotlin.collections.MapsKt.mapOf(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r16 = 0
            r17 = 0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r15, r6)
            java.lang.Object r15 = r13.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r12 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r15 != r12) goto L_0x021a
            r21 = 1
            goto L_0x021c
        L_0x021a:
            r21 = 0
        L_0x021c:
            r12 = 0
            r72 = r3
            r3 = 1
            r15 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r1, r12, r3, r15)
            androidx.compose.material3.SwipeableState r17 = r4.getSwipeableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r19 = androidx.compose.foundation.gestures.Orientation.Horizontal
            float r25 = DrawerVelocityThreshold
            r22 = 0
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1 r3 = androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE
            r23 = r3
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            r24 = 0
            r26 = 32
            r27 = 0
            r18 = r10
            r20 = r7
            androidx.compose.ui.Modifier r3 = androidx.compose.material3.SwipeableKt.m2108swipeablepPrIpRY$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r12 = 0
            r15 = r12
            r12 = 0
            r16 = r1
            r1 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            androidx.compose.ui.Alignment$Companion r17 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r17.getTopStart()
            r17 = r12
            r12 = 0
            int r19 = r15 >> 3
            r19 = r19 & 14
            int r20 = r15 >> 3
            r20 = r20 & 112(0x70, float:1.57E-43)
            r32 = r8
            r8 = r19 | r20
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r12, r13, r8)
            int r9 = r15 << 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            r19 = 0
            r20 = r10
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r10)
            java.lang.String r10 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r22 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r34 = r12
            r12 = r22
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r22 = 6
            r23 = 0
            r35 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r14, r6)
            java.lang.Object r14 = r13.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r12 = r14
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r22 = 6
            r23 = 0
            r36 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            java.lang.Object r5 = r13.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r22 = 6
            r23 = 0
            r37 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r2, r6)
            java.lang.Object r2 = r13.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r22 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            r38 = r3
            int r3 = r9 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r23 = 6
            r3 = r3 | 6
            r39 = r22
            r40 = 0
            r41 = r9
            androidx.compose.runtime.Applier r9 = r13.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0303
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0303:
            r13.startReusableNode()
            boolean r9 = r13.getInserting()
            if (r9 == 0) goto L_0x0310
            r13.createNode(r14)
            goto L_0x0313
        L_0x0310:
            r13.useNode()
        L_0x0313:
            r13.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m2787constructorimpl(r13)
            r22 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r23 = androidx.compose.ui.node.ComposeUiNode.Companion
            r42 = r14
            kotlin.jvm.functions.Function2 r14 = r23.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r8, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r12, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r5, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r2, r14)
            r13.enableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r9)
            int r14 = r3 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r43 = r2
            r2 = r39
            r2.invoke(r9, r13, r14)
            r9 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r9)
            int r14 = r3 >> 9
            r14 = r14 & 14
            r22 = r13
            r39 = r22
            r44 = 0
            r9 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r45 = r2
            r2 = r39
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            r46 = r3
            r3 = r14 & 11
            r47 = r5
            r5 = 2
            if (r3 != r5) goto L_0x03a3
            boolean r3 = r2.getSkipping()
            if (r3 != 0) goto L_0x038c
            goto L_0x03a3
        L_0x038c:
            r2.skipToGroupEnd()
            r3 = r68
            r56 = r2
            r71 = r4
            r73 = r7
            r51 = r8
            r52 = r12
            r55 = r13
            r53 = r14
            r54 = r15
            goto L_0x07e4
        L_0x03a3:
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r5 = r15 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r22 = 6
            r5 = r5 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r48 = r2
            r49 = 0
            r50 = r3
            r3 = -1313342074(0xffffffffb1b7fd86, float:-5.3548233E-9)
            r51 = r8
            r8 = r48
            r8.startReplaceableGroup(r3)
            java.lang.String r3 = "C284@10391L37,297@10786L95,287@10437L486,304@10982L55,302@10932L683:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            r3 = r5 & 81
            r48 = r5
            r5 = 16
            if (r3 != r5) goto L_0x03e8
            boolean r3 = r8.getSkipping()
            if (r3 != 0) goto L_0x03d3
            goto L_0x03e8
        L_0x03d3:
            r8.skipToGroupEnd()
            r3 = r68
            r56 = r2
            r71 = r4
            r73 = r7
            r52 = r12
            r55 = r13
            r53 = r14
            r54 = r15
            goto L_0x07e0
        L_0x03e8:
            r3 = 0
            r5 = 0
            r22 = r5
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r8.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.ui.Alignment$Companion r23 = androidx.compose.ui.Alignment.Companion
            r52 = r12
            androidx.compose.ui.Alignment r12 = r23.getTopStart()
            r53 = r14
            r14 = 0
            int r23 = r3 >> 3
            r23 = r23 & 14
            int r24 = r3 >> 3
            r24 = r24 & 112(0x70, float:1.57E-43)
            r54 = r15
            r15 = r23 | r24
            androidx.compose.ui.layout.MeasurePolicy r15 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r14, r8, r15)
            int r23 = r3 << 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r24 = 0
            r25 = r12
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r26 = 6
            r27 = 0
            r28 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r14, r6)
            java.lang.Object r14 = r8.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r12 = r14
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r26 = 6
            r27 = 0
            r55 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r13, r6)
            java.lang.Object r13 = r8.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r26 = 6
            r27 = 0
            r56 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r6)
            java.lang.Object r2 = r8.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r26 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            r27 = r5
            int r5 = r23 << 9
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r31 = 6
            r5 = r5 | 6
            r57 = r26
            r26 = 0
            r58 = r6
            androidx.compose.runtime.Applier r6 = r8.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x049e
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x049e:
            r8.startReusableNode()
            boolean r6 = r8.getInserting()
            if (r6 == 0) goto L_0x04ab
            r8.createNode(r14)
            goto L_0x04ae
        L_0x04ab:
            r8.useNode()
        L_0x04ae:
            r8.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m2787constructorimpl(r8)
            r59 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r60 = androidx.compose.ui.node.ComposeUiNode.Companion
            r61 = r14
            kotlin.jvm.functions.Function2 r14 = r60.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r15, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r12, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r13, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r2, r14)
            r8.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r6)
            int r14 = r5 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r59 = r2
            r2 = r57
            r2.invoke(r6, r8, r14)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r6)
            int r6 = r5 >> 9
            r6 = r6 & 14
            r14 = r8
            r57 = 0
            r60 = r2
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r14.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r9)
            r2 = r6 & 11
            r62 = r5
            r5 = 2
            if (r2 != r5) goto L_0x0524
            boolean r2 = r14.getSkipping()
            if (r2 != 0) goto L_0x051e
            goto L_0x0524
        L_0x051e:
            r14.skipToGroupEnd()
            r66 = r3
            goto L_0x0567
        L_0x0524:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r5 = r3 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r31 = 6
            r5 = r5 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r63 = r14
            r64 = 0
            r65 = r2
            r2 = 573344012(0x222c890c, float:2.3382899E-18)
            r66 = r3
            r3 = r63
            r3.startReplaceableGroup(r2)
            java.lang.String r2 = "C285@10409L9:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r2)
            r2 = r5 & 81
            r63 = r5
            r5 = 16
            if (r2 != r5) goto L_0x0558
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x0554
            goto L_0x0558
        L_0x0554:
            r3.skipToGroupEnd()
            goto L_0x0563
        L_0x0558:
            int r2 = r0 >> 15
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r11.invoke(r3, r2)
        L_0x0563:
            r3.endReplaceableGroup()
        L_0x0567:
            r14.endReplaceableGroup()
            r8.endReplaceableGroup()
            r8.endNode()
            r8.endReplaceableGroup()
            r8.endReplaceableGroup()
            boolean r22 = r4.isOpen()
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2 r2 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2
            r3 = r37
            r2.<init>(r7, r4, r3)
            r23 = r2
            kotlin.jvm.functions.Function0 r23 = (kotlin.jvm.functions.Function0) r23
            java.lang.Float r2 = java.lang.Float.valueOf(r36)
            java.lang.Float r5 = java.lang.Float.valueOf(r35)
            r6 = r0 & 896(0x380, float:1.256E-42)
            r6 = r6 | 48
            r12 = 0
            r13 = 1618982084(0x607fb4c4, float:7.370227E19)
            r8.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r13)
            boolean r13 = r8.changed((java.lang.Object) r2)
            boolean r14 = r8.changed((java.lang.Object) r5)
            r13 = r13 | r14
            boolean r14 = r8.changed((java.lang.Object) r4)
            r13 = r13 | r14
            r14 = r8
            r15 = 0
            r24 = r2
            java.lang.Object r2 = r14.rememberedValue()
            r25 = 0
            if (r13 != 0) goto L_0x05d1
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            r27 = r5
            java.lang.Object r5 = r26.getEmpty()
            if (r2 != r5) goto L_0x05c6
            goto L_0x05d3
        L_0x05c6:
            r26 = r2
            r5 = r36
            r67 = r35
            r35 = r6
            r6 = r67
            goto L_0x05eb
        L_0x05d1:
            r27 = r5
        L_0x05d3:
            r5 = 0
            r26 = r2
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1 r2 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
            r28 = r5
            r5 = r36
            r67 = r35
            r35 = r6
            r6 = r67
            r2.<init>(r5, r6, r4)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r14.updateRememberedValue(r2)
        L_0x05eb:
            r8.endReplaceableGroup()
            r24 = r2
            kotlin.jvm.functions.Function0 r24 = (kotlin.jvm.functions.Function0) r24
            int r2 = r0 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r25 = r32
            r27 = r8
            r28 = r2
            m2011ScrimBx497Mc(r22, r23, r24, r25, r27, r28)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            int r12 = r0 >> 6
            r12 = r12 & 14
            r13 = 0
            r14 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r14)
            java.lang.String r14 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r14)
            boolean r14 = r8.changed((java.lang.Object) r4)
            r15 = r8
            r22 = 0
            r36 = r5
            java.lang.Object r5 = r15.rememberedValue()
            r23 = 0
            if (r14 != 0) goto L_0x0635
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r35 = r6
            java.lang.Object r6 = r24.getEmpty()
            if (r5 != r6) goto L_0x0632
            goto L_0x0637
        L_0x0632:
            r24 = r5
            goto L_0x0645
        L_0x0635:
            r35 = r6
        L_0x0637:
            r6 = 0
            r24 = r5
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1 r5 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
            r5.<init>(r4)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r15.updateRememberedValue(r5)
        L_0x0645:
            r8.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r5)
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5 r5 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5
            r6 = r72
            r5.<init>(r6, r4, r3)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r12 = 0
            r13 = 0
            r14 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r13, r5, r14, r12)
            r5 = r13
            r12 = 0
            r13 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r8.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r13 = 0
            int r14 = r5 >> 3
            r14 = r14 & 14
            int r15 = r5 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r13, r8, r14)
            int r15 = r5 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r22 = 0
            r69 = r1
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r10 = 6
            r23 = 0
            r37 = r3
            r71 = r4
            r3 = r58
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r3)
            java.lang.Object r4 = r8.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r1 = r4
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r10 = 6
            r23 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r3)
            java.lang.Object r6 = r8.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r4 = r6
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r10 = 6
            r23 = 0
            r73 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r7, r3)
            java.lang.Object r3 = r8.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            int r10 = r15 << 9
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r23 = 6
            r10 = r10 | 6
            r23 = 0
            r70 = r2
            androidx.compose.runtime.Applier r2 = r8.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x0705
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0705:
            r8.startReusableNode()
            boolean r2 = r8.getInserting()
            if (r2 == 0) goto L_0x0712
            r8.createNode(r6)
            goto L_0x0715
        L_0x0712:
            r8.useNode()
        L_0x0715:
            r8.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2787constructorimpl(r8)
            r24 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r25 = androidx.compose.ui.node.ComposeUiNode.Companion
            r26 = r6
            kotlin.jvm.functions.Function2 r6 = r25.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r14, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r4, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r3, r6)
            r8.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r2)
            int r6 = r10 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.invoke(r2, r8, r6)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r2)
            int r2 = r10 >> 9
            r2 = r2 & 14
            r6 = r8
            r24 = 0
            r25 = r1
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r6.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r9)
            r1 = r2 & 11
            r9 = 2
            if (r1 != r9) goto L_0x0789
            boolean r1 = r6.getSkipping()
            if (r1 != 0) goto L_0x077f
            goto L_0x0789
        L_0x077f:
            r6.skipToGroupEnd()
            r30 = r2
            r27 = r3
            r3 = r68
            goto L_0x07ce
        L_0x0789:
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r9 = r5 >> 6
            r9 = r9 & 112(0x70, float:1.57E-43)
            r27 = 6
            r9 = r9 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r27 = r6
            r28 = 0
            r29 = r1
            r1 = 381037187(0x16b62a83, float:2.9430515E-25)
            r30 = r2
            r2 = r27
            r2.startReplaceableGroup(r1)
            java.lang.String r1 = "C319@11590L15:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r1 = r9 & 81
            r27 = r3
            r3 = 16
            if (r1 != r3) goto L_0x07bf
            boolean r1 = r2.getSkipping()
            if (r1 != 0) goto L_0x07b9
            goto L_0x07bf
        L_0x07b9:
            r2.skipToGroupEnd()
            r3 = r68
            goto L_0x07ca
        L_0x07bf:
            r1 = r0 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3 = r68
            r3.invoke(r2, r1)
        L_0x07ca:
            r2.endReplaceableGroup()
        L_0x07ce:
            r6.endReplaceableGroup()
            r8.endReplaceableGroup()
            r8.endNode()
            r8.endReplaceableGroup()
            r8.endReplaceableGroup()
        L_0x07e0:
            r8.endReplaceableGroup()
        L_0x07e4:
            r56.endReplaceableGroup()
            r55.endReplaceableGroup()
            r55.endNode()
            r55.endReplaceableGroup()
            r55.endReplaceableGroup()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x07ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x07ff:
            r10 = r71
            r12 = r73
            r13 = r0
        L_0x0804:
            androidx.compose.runtime.ScopeUpdateScope r14 = r55.endRestartGroup()
            if (r14 != 0) goto L_0x080b
            goto L_0x0824
        L_0x080b:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3 r15 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3
            r0 = r15
            r1 = r68
            r2 = r16
            r3 = r10
            r4 = r12
            r5 = r32
            r7 = r74
            r8 = r76
            r9 = r77
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0824:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2009ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    @ExperimentalMaterial3Api
    public static final void DismissibleNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, DrawerState drawerState, boolean gesturesEnabled, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        DrawerState drawerState2;
        boolean gesturesEnabled2;
        DrawerState drawerState3;
        Composer $composer2;
        boolean gesturesEnabled3;
        Modifier modifier3;
        DrawerState drawerState4;
        Modifier modifier4;
        Composer $composer$iv;
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function2 = drawerContent;
        Function2<? super Composer, ? super Integer, Unit> function22 = content;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(function2, "drawerContent");
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer $composer3 = $composer.startRestartGroup(398812198);
        ComposerKt.sourceInformation($composer3, "C(DismissibleNavigationDrawer)P(1,4,2,3)349@12871L39,*354@13091L7,358@13196L24,359@13246L33,362@13404L7,363@13439L1566:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer3.changed((Object) function2) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                drawerState2 = drawerState;
                if ($composer3.changed((Object) drawerState2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                drawerState2 = drawerState;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            drawerState2 = drawerState;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            gesturesEnabled2 = gesturesEnabled;
        } else if ((i3 & 7168) == 0) {
            gesturesEnabled2 = gesturesEnabled;
            $dirty |= $composer3.changed(gesturesEnabled2) ? 2048 : 1024;
        } else {
            gesturesEnabled2 = gesturesEnabled;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i3) == 0) {
            $dirty |= $composer3.changed((Object) function22) ? 16384 : 8192;
        }
        if ((46811 & $dirty) != 9362 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i3 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    drawerState4 = rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, $composer3, 6, 2);
                    $dirty &= -897;
                } else {
                    drawerState4 = drawerState2;
                }
                if (i5 != 0) {
                    gesturesEnabled2 = true;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                drawerState4 = drawerState2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(398812198, $dirty, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:346)");
            }
            float drawerWidth = NavigationDrawerTokens.INSTANCE.m2525getContainerWidthD9Ej5fM();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float drawerWidthPx = ((Density) consume).m5967toPx0680j_4(drawerWidth);
            float minValue = -drawerWidthPx;
            $composer3.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            Composer composer$iv = $composer3;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv$iv = $composer3;
            Object value$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
            if (value$iv$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv$iv;
                float f = drawerWidth;
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext) EmptyCoroutineContext.INSTANCE, composer$iv));
                $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
            } else {
                Object it$iv$iv$iv = value$iv$iv$iv;
                float f2 = drawerWidth;
                Composer composer = $this$cache$iv$iv$iv;
            }
            $composer3.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
            $composer3.endReplaceableGroup();
            CoroutineScope scope = coroutineScope;
            String navigationMenu = Strings_androidKt.m2089getStringNWtq28(Strings.Companion.m2086getNavigationMenuadMyvUU(), $composer3, 6);
            Map anchors = MapsKt.mapOf(TuplesKt.to(Float.valueOf(minValue), DrawerValue.Closed), TuplesKt.to(Float.valueOf(0.0f), DrawerValue.Open));
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier5 = modifier4;
            Modifier modifier$iv = SwipeableKt.m2108swipeablepPrIpRY$default(modifier4, drawerState4.getSwipeableState$material3_release(), anchors, Orientation.Horizontal, gesturesEnabled2, consume2 == LayoutDirection.Rtl, (MutableInteractionSource) null, NavigationDrawerKt$DismissibleNavigationDrawer$1.INSTANCE, (ResistanceConfig) null, DrawerVelocityThreshold, 32, (Object) null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            float f3 = drawerWidthPx;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            gesturesEnabled3 = gesturesEnabled2;
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            Alignment alignment = contentAlignment$iv;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            float f4 = minValue;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume3;
            Map map = anchors;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier6 = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            Composer $composer$iv2 = $composer3;
            $composer$iv2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            if (($changed$iv & 11) != 2 || !$composer$iv2.getSkipping()) {
                int $changed2 = ((0 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                LayoutDirection layoutDirection = layoutDirection$iv$iv;
                Composer $composer4 = $composer$iv2;
                $composer4.startReplaceableGroup(254773804);
                ComposerKt.sourceInformation($composer4, "C375@13855L1144:NavigationDrawer.kt#uh7d8r");
                int i6 = $changed2;
                if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                    MeasurePolicy measurePolicy$iv2 = new NavigationDrawerKt$DismissibleNavigationDrawer$2$2(drawerState4);
                    int i7 = $changed$iv;
                    $composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
                    Modifier modifier$iv2 = Modifier.Companion;
                    int i8 = $changed$iv$iv$iv;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Density density$iv = (Density) consume6;
                    $composer2 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume7 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    LayoutDirection layoutDirection$iv = (LayoutDirection) consume7;
                    $composer$iv = $composer$iv2;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume8 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume8;
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
                    Modifier modifier7 = modifier$iv2;
                    int $changed$iv$iv = ((0 << 9) & 7168) | 6;
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
                    Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer4);
                    Function0<ComposeUiNode> function02 = constructor2;
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                    $composer4.enableReusing();
                    ViewConfiguration viewConfiguration2 = viewConfiguration$iv;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                    function35.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                    $composer4.startReplaceableGroup(2058660585);
                    int $changed3 = ($changed$iv$iv >> 9) & 14;
                    Composer $composer5 = $composer4;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = function35;
                    $composer5.startReplaceableGroup(1983447907);
                    ComposerKt.sourceInformation($composer5, "C376@13886L523,391@14422L45:NavigationDrawer.kt#uh7d8r");
                    MeasurePolicy measurePolicy2 = measurePolicy$iv2;
                    if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                        CoroutineScope coroutineScope2 = scope;
                        drawerState3 = drawerState4;
                        String str = navigationMenu;
                        Modifier modifier$iv3 = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1(navigationMenu, drawerState4, scope), 1, (Object) null);
                        $composer5.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        $composer5.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        Alignment alignment2 = contentAlignment$iv2;
                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume9 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        Density density$iv$iv2 = (Density) consume9;
                        int i9 = $changed3;
                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume10 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume10;
                        LayoutDirection layoutDirection2 = layoutDirection$iv;
                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume11 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume11;
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier$iv3);
                        Modifier modifier8 = modifier$iv3;
                        int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function37 = materializerOf3;
                        int i10 = $changed$iv$iv;
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
                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer5);
                        Function0<ComposeUiNode> function03 = constructor3;
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                        $composer5.enableReusing();
                        Density density2 = density$iv$iv2;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function38 = function37;
                        function38.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                        $composer5.startReplaceableGroup(2058660585);
                        Composer $composer$iv3 = $composer5;
                        int i11 = $changed$iv$iv$iv2;
                        $composer$iv3.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation($composer$iv3, "C72@3384L9:Box.kt#2w3rfo");
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function39 = function38;
                        if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv3.getSkipping()) {
                            int $changed4 = ((0 >> 6) & 112) | 6;
                            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                            Composer $composer6 = $composer$iv3;
                            $composer6.startReplaceableGroup(-170061591);
                            ComposerKt.sourceInformation($composer6, "C389@14380L15:NavigationDrawer.kt#uh7d8r");
                            int i12 = $changed4;
                            if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                                drawerContent.invoke($composer6, Integer.valueOf($dirty & 14));
                            } else {
                                $composer6.skipToGroupEnd();
                                Function2<? super Composer, ? super Integer, Unit> function23 = drawerContent;
                            }
                            $composer6.endReplaceableGroup();
                        } else {
                            $composer$iv3.skipToGroupEnd();
                            Function2<? super Composer, ? super Integer, Unit> function24 = drawerContent;
                        }
                        $composer$iv3.endReplaceableGroup();
                        $composer5.endReplaceableGroup();
                        $composer5.endNode();
                        $composer5.endReplaceableGroup();
                        $composer5.endReplaceableGroup();
                        $composer5.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Modifier modifier$iv4 = Modifier.Companion;
                        Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        $composer5.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume12 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        Density density$iv$iv3 = (Density) consume12;
                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume13 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume13;
                        Alignment alignment3 = contentAlignment$iv3;
                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume14 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume14;
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv4);
                        Modifier modifier9 = modifier$iv4;
                        int $changed$iv$iv$iv3 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                        if (!($composer5.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer5.startReusableNode();
                        if ($composer5.getInserting()) {
                            $composer5.createNode(constructor4);
                        } else {
                            $composer5.useNode();
                        }
                        $composer5.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2787constructorimpl($composer5);
                        Function0<ComposeUiNode> function04 = constructor4;
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
                        $composer5.enableReusing();
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
                        $composer5.startReplaceableGroup(2058660585);
                        Composer $composer$iv4 = $composer5;
                        int i13 = $changed$iv$iv$iv3;
                        $composer$iv4.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation($composer$iv4, "C72@3384L9:Box.kt#2w3rfo");
                        if ((($changed$iv$iv$iv3 >> 9) & 14 & 11) != 2 || !$composer$iv4.getSkipping()) {
                            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                            Composer $composer7 = $composer$iv4;
                            $composer7.startReplaceableGroup(115715936);
                            ComposerKt.sourceInformation($composer7, "C392@14444L9:NavigationDrawer.kt#uh7d8r");
                            ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv3;
                            if (((((0 >> 6) & 112) | 6) & 81) != 16 || !$composer7.getSkipping()) {
                                content.invoke($composer7, Integer.valueOf(($dirty >> 12) & 14));
                            } else {
                                $composer7.skipToGroupEnd();
                                Function2<? super Composer, ? super Integer, Unit> function25 = content;
                            }
                            $composer7.endReplaceableGroup();
                        } else {
                            $composer$iv4.skipToGroupEnd();
                            ViewConfiguration viewConfiguration4 = viewConfiguration$iv$iv3;
                            Function2<? super Composer, ? super Integer, Unit> function26 = content;
                        }
                        $composer$iv4.endReplaceableGroup();
                        $composer5.endReplaceableGroup();
                        $composer5.endNode();
                        $composer5.endReplaceableGroup();
                        $composer5.endReplaceableGroup();
                    } else {
                        $composer5.skipToGroupEnd();
                        Function2<? super Composer, ? super Integer, Unit> function27 = content;
                        CoroutineScope coroutineScope3 = scope;
                        drawerState3 = drawerState4;
                        String str2 = navigationMenu;
                        int i14 = $changed3;
                        LayoutDirection layoutDirection3 = layoutDirection$iv;
                        int i15 = $changed$iv$iv;
                    }
                    $composer5.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    $composer4.endNode();
                    $composer4.endReplaceableGroup();
                } else {
                    $composer4.skipToGroupEnd();
                    Function2<? super Composer, ? super Integer, Unit> function28 = content;
                    CoroutineScope coroutineScope4 = scope;
                    drawerState3 = drawerState4;
                    String str3 = navigationMenu;
                    $composer$iv = $composer$iv2;
                    $composer2 = $composer3;
                    int i16 = $changed$iv;
                    int i17 = $changed$iv$iv$iv;
                }
                $composer4.endReplaceableGroup();
            } else {
                $composer$iv2.skipToGroupEnd();
                Function2<? super Composer, ? super Integer, Unit> function29 = content;
                CoroutineScope coroutineScope5 = scope;
                drawerState3 = drawerState4;
                String str4 = navigationMenu;
                $composer$iv = $composer$iv2;
                $composer2 = $composer3;
                LayoutDirection layoutDirection4 = layoutDirection$iv$iv;
                int i18 = $changed$iv;
                int i19 = $changed$iv$iv$iv;
            }
            $composer$iv.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            int i20 = $dirty;
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            drawerState3 = drawerState2;
            gesturesEnabled3 = gesturesEnabled2;
            Function2<? super Composer, ? super Integer, Unit> function210 = function22;
            $composer2 = $composer3;
            int i21 = $dirty;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationDrawerKt$DismissibleNavigationDrawer$3(drawerContent, modifier3, drawerState3, gesturesEnabled3, content, $changed, i));
        }
    }

    @ExperimentalMaterial3Api
    public static final void PermanentNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function2 = drawerContent;
        Function2<? super Composer, ? super Integer, Unit> function22 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function2, "drawerContent");
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer $composer2 = $composer.startRestartGroup(-276843608);
        ComposerKt.sourceInformation($composer2, "C(PermanentNavigationDrawer)P(1,2)432@16062L105:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) function2) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer2.changed((Object) function22) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-276843608, $dirty2, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:427)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            Arrangement.Horizontal horizontal = horizontalArrangement$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier5 = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            Alignment.Vertical vertical = verticalAlignment$iv;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer2);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            int i4 = $changed$iv$iv$iv;
            Composer $composer$iv = $composer2;
            $composer$iv.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation($composer$iv, "C80@3988L9:Row.kt#2w3rfo");
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            if (($changed$iv & 11) != 2 || !$composer$iv.getSkipping()) {
                int $changed2 = ((0 >> 6) & 112) | 6;
                RowScope rowScope = RowScopeInstance.INSTANCE;
                Composer $composer3 = $composer$iv;
                $composer3.startReplaceableGroup(109704460);
                ComposerKt.sourceInformation($composer3, "C433@16100L15,434@16124L37:NavigationDrawer.kt#uh7d8r");
                Density density = density$iv$iv;
                if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                    function2.invoke($composer3, Integer.valueOf($dirty2 & 14));
                    $composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Modifier modifier$iv2 = Modifier.Companion;
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                    int i5 = $changed2;
                    MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    Alignment alignment = contentAlignment$iv;
                    $composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density$iv$iv2 = (Density) consume4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                    int i6 = $changed$iv;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                    Modifier modifier6 = modifier$iv2;
                    int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                    MeasurePolicy measurePolicy = measurePolicy$iv;
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
                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer3);
                    Function0<ComposeUiNode> function02 = constructor2;
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                    $composer3.enableReusing();
                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                    $composer3.startReplaceableGroup(2058660585);
                    Composer $composer$iv2 = $composer3;
                    int i7 = $changed$iv$iv$iv2;
                    $composer$iv2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                    Density density2 = density$iv$iv2;
                    if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                        int $changed3 = ((0 >> 6) & 112) | 6;
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        Composer $composer4 = $composer$iv2;
                        $composer4.startReplaceableGroup(612624658);
                        ComposerKt.sourceInformation($composer4, "C435@16142L9:NavigationDrawer.kt#uh7d8r");
                        int i8 = $changed3;
                        if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                            function22.invoke($composer4, Integer.valueOf(($dirty2 >> 6) & 14));
                        } else {
                            $composer4.skipToGroupEnd();
                        }
                        $composer4.endReplaceableGroup();
                    } else {
                        $composer$iv2.skipToGroupEnd();
                    }
                    $composer$iv2.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                } else {
                    $composer3.skipToGroupEnd();
                    ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                    int i9 = $changed2;
                    int i10 = $changed$iv;
                    MeasurePolicy measurePolicy2 = measurePolicy$iv;
                }
                $composer3.endReplaceableGroup();
            } else {
                $composer$iv.skipToGroupEnd();
                Density density3 = density$iv$iv;
                ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv;
                int i11 = $changed$iv;
                MeasurePolicy measurePolicy3 = measurePolicy$iv;
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
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationDrawerKt$PermanentNavigationDrawer$2(drawerContent, modifier3, content, $changed, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0103  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: ModalDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2008ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r12 = r33
            r13 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1001163336(0x3bac8a48, float:0.005265508)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ModalDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)460@17296L5,461@17351L11,462@17404L37,464@17559L12,467@17629L183:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r35
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r25
            goto L_0x0035
        L_0x0022:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r25
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
            r3 = r25
        L_0x0035:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r36 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r26
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004a
            r5 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r26
        L_0x004a:
            r5 = 16
        L_0x004c:
            r1 = r1 | r5
            goto L_0x0050
        L_0x004e:
            r4 = r26
        L_0x0050:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r36 & 4
            if (r5 != 0) goto L_0x0063
            r5 = r27
            boolean r7 = r14.changed((long) r5)
            if (r7 == 0) goto L_0x0065
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r5 = r27
        L_0x0065:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r7
            goto L_0x006b
        L_0x0069:
            r5 = r27
        L_0x006b:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0084
            r7 = r36 & 8
            if (r7 != 0) goto L_0x007e
            r7 = r29
            boolean r9 = r14.changed((long) r7)
            if (r9 == 0) goto L_0x0080
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x007e:
            r7 = r29
        L_0x0080:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r1 = r1 | r9
            goto L_0x0086
        L_0x0084:
            r7 = r29
        L_0x0086:
            r9 = r36 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0092
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r11 = r31
            goto L_0x00a7
        L_0x0092:
            r11 = r13 & r10
            if (r11 != 0) goto L_0x00a5
            r11 = r31
            boolean r15 = r14.changed((float) r11)
            if (r15 == 0) goto L_0x00a1
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r15
            goto L_0x00a7
        L_0x00a5:
            r11 = r31
        L_0x00a7:
            r15 = 458752(0x70000, float:6.42848E-40)
            r16 = r13 & r15
            if (r16 != 0) goto L_0x00c3
            r16 = r36 & 32
            if (r16 != 0) goto L_0x00bc
            r15 = r32
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00be
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00bc:
            r15 = r32
        L_0x00be:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r1 = r1 | r16
            goto L_0x00c5
        L_0x00c3:
            r15 = r32
        L_0x00c5:
            r16 = r36 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d0
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00cd:
            r1 = r1 | r16
            goto L_0x00e0
        L_0x00d0:
            r16 = r13 & r17
            if (r16 != 0) goto L_0x00e0
            boolean r16 = r14.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00dd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00dd:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00cd
        L_0x00e0:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r1 & r16
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r0) goto L_0x0103
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00f1
            goto L_0x0103
        L_0x00f1:
            r14.skipToGroupEnd()
            r17 = r1
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r24 = r15
            r15 = r3
            goto L_0x0208
        L_0x0103:
            r14.startDefaults()
            r0 = r13 & 1
            r10 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x014b
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0114
            goto L_0x014b
        L_0x0114:
            r14.skipToGroupEnd()
            r0 = r36 & 2
            if (r0 == 0) goto L_0x011d
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x011d:
            r0 = r36 & 4
            if (r0 == 0) goto L_0x0123
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0123:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x0129
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0129:
            r0 = r36 & 32
            if (r0 == 0) goto L_0x013d
            r0 = r1 & r10
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r24 = r15
            r11 = r0
            r15 = r3
            goto L_0x01ac
        L_0x013d:
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r24 = r15
            r11 = r1
            r15 = r3
            goto L_0x01ac
        L_0x014b:
            if (r2 == 0) goto L_0x0152
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0153
        L_0x0152:
            r0 = r3
        L_0x0153:
            r2 = r36 & 2
            r3 = 6
            if (r2 == 0) goto L_0x0161
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r14, r3)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            r4 = r2
        L_0x0161:
            r2 = r36 & 4
            if (r2 == 0) goto L_0x0171
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r14, r3)
            long r5 = r2.m1818getSurface0d7_KjU()
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0171:
            r2 = r36 & 8
            if (r2 == 0) goto L_0x017f
            int r2 = r1 >> 6
            r2 = r2 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r5, r14, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x017f:
            if (r9 == 0) goto L_0x0188
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1897getModalDrawerElevationD9Ej5fM()
            r11 = r2
        L_0x0188:
            r2 = r36 & 32
            if (r2 == 0) goto L_0x01a0
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r14, r3)
            r1 = r1 & r10
            r15 = r0
            r24 = r2
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r11 = r1
            goto L_0x01ac
        L_0x01a0:
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r24 = r15
            r15 = r0
            r11 = r1
        L_0x01ac:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01be
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:458)"
            r2 = 1001163336(0x3bac8a48, float:0.005265508)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r0, r1)
        L_0x01be:
            int r0 = r11 >> 15
            r0 = r0 & 14
            int r1 = r11 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r11 << 3
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r11 << 3
            r2 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r2
            r0 = r0 | r1
            r1 = r11 & r17
            r10 = r0 | r1
            r16 = 0
            r0 = r24
            r1 = r15
            r2 = r18
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r33
            r9 = r14
            r17 = r11
            r11 = r16
            m2007DrawerSheetvywBR7E(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0208
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0208:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x020f
            goto L_0x022f
        L_0x020f:
            androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1 r16 = new androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1
            r0 = r16
            r1 = r15
            r2 = r18
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r24
            r9 = r33
            r10 = r35
            r12 = r11
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x022f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2008ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0108  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: DismissibleDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2006DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r12 = r33
            r13 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -588600583(0xffffffffdceaaaf9, float:-5.28425048E17)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)499@19008L11,500@19061L37,502@19222L12,505@19292L183:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r35
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r25
            goto L_0x0035
        L_0x0022:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r25
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
            r3 = r25
        L_0x0035:
            r4 = r36 & 2
            if (r4 == 0) goto L_0x003e
            r1 = r1 | 48
            r5 = r26
            goto L_0x0053
        L_0x003e:
            r5 = r13 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r26
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r1 = r1 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r26
        L_0x0053:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006c
            r6 = r36 & 4
            if (r6 != 0) goto L_0x0066
            r6 = r27
            boolean r8 = r14.changed((long) r6)
            if (r8 == 0) goto L_0x0068
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0066:
            r6 = r27
        L_0x0068:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r1 = r1 | r8
            goto L_0x006e
        L_0x006c:
            r6 = r27
        L_0x006e:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0087
            r8 = r36 & 8
            if (r8 != 0) goto L_0x0081
            r8 = r29
            boolean r10 = r14.changed((long) r8)
            if (r10 == 0) goto L_0x0083
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0081:
            r8 = r29
        L_0x0083:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r10
            goto L_0x0089
        L_0x0087:
            r8 = r29
        L_0x0089:
            r10 = r36 & 16
            r11 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0095
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r15 = r31
            goto L_0x00ab
        L_0x0095:
            r15 = r13 & r11
            if (r15 != 0) goto L_0x00a9
            r15 = r31
            boolean r16 = r14.changed((float) r15)
            if (r16 == 0) goto L_0x00a4
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r16
            goto L_0x00ab
        L_0x00a9:
            r15 = r31
        L_0x00ab:
            r16 = 458752(0x70000, float:6.42848E-40)
            r17 = r13 & r16
            if (r17 != 0) goto L_0x00c7
            r17 = r36 & 32
            if (r17 != 0) goto L_0x00c0
            r11 = r32
            boolean r17 = r14.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x00c2
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c0:
            r11 = r32
        L_0x00c2:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r17
            goto L_0x00c9
        L_0x00c7:
            r11 = r32
        L_0x00c9:
            r17 = r36 & 64
            r18 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00d4
            r17 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00e4
        L_0x00d4:
            r17 = r13 & r18
            if (r17 != 0) goto L_0x00e4
            boolean r17 = r14.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x00e1
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00e1:
            r17 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d1
        L_0x00e4:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r17
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x0108
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00f5
            goto L_0x0108
        L_0x00f5:
            r14.skipToGroupEnd()
            r18 = r1
            r17 = r5
            r19 = r6
            r21 = r8
            r24 = r11
            r23 = r15
            r15 = r25
            goto L_0x0203
        L_0x0108:
            r14.startDefaults()
            r0 = r13 & 1
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x014c
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0119
            goto L_0x014c
        L_0x0119:
            r14.skipToGroupEnd()
            r0 = r36 & 4
            if (r0 == 0) goto L_0x0122
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0122:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x0128
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0128:
            r0 = r36 & 32
            if (r0 == 0) goto L_0x013d
            r0 = r1 & r3
            r17 = r5
            r19 = r6
            r21 = r8
            r24 = r11
            r23 = r15
            r15 = r25
            r11 = r0
            goto L_0x01a8
        L_0x013d:
            r17 = r5
            r19 = r6
            r21 = r8
            r24 = r11
            r23 = r15
            r15 = r25
            r11 = r1
            goto L_0x01a8
        L_0x014c:
            if (r2 == 0) goto L_0x0153
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0155
        L_0x0153:
            r0 = r25
        L_0x0155:
            if (r4 == 0) goto L_0x015c
            androidx.compose.ui.graphics.Shape r2 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r5 = r2
        L_0x015c:
            r2 = r36 & 4
            r4 = 6
            if (r2 == 0) goto L_0x016d
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r14, r4)
            long r6 = r2.m1818getSurface0d7_KjU()
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x016d:
            r2 = r36 & 8
            if (r2 == 0) goto L_0x017b
            int r2 = r1 >> 6
            r2 = r2 & 14
            long r8 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r6, r14, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x017b:
            if (r10 == 0) goto L_0x0184
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1895getDismissibleDrawerElevationD9Ej5fM()
            r15 = r2
        L_0x0184:
            r2 = r36 & 32
            if (r2 == 0) goto L_0x019c
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r14, r4)
            r1 = r1 & r3
            r11 = r1
            r24 = r2
            r17 = r5
            r19 = r6
            r21 = r8
            r23 = r15
            r15 = r0
            goto L_0x01a8
        L_0x019c:
            r17 = r5
            r19 = r6
            r21 = r8
            r24 = r11
            r23 = r15
            r15 = r0
            r11 = r1
        L_0x01a8:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ba
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:496)"
            r2 = -588600583(0xffffffffdceaaaf9, float:-5.28425048E17)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r0, r1)
        L_0x01ba:
            int r0 = r11 >> 15
            r0 = r0 & 14
            int r1 = r11 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r11 << 3
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & r16
            r0 = r0 | r1
            r1 = r11 & r18
            r10 = r0 | r1
            r16 = 0
            r0 = r24
            r1 = r15
            r2 = r17
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r33
            r9 = r14
            r18 = r11
            r11 = r16
            m2007DrawerSheetvywBR7E(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0203
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0203:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x020a
            goto L_0x022a
        L_0x020a:
            androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1 r16 = new androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1
            r0 = r16
            r1 = r15
            r2 = r17
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r24
            r9 = r33
            r10 = r35
            r12 = r11
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x022a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2006DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0108  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: PermanentDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2010PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier r26, androidx.compose.ui.graphics.Shape r27, long r28, long r30, float r32, androidx.compose.foundation.layout.WindowInsets r33, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r12 = r34
            r13 = r36
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1733353241(0xffffffff98af20e7, float:-4.5269663E-24)
            r1 = r35
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)537@20662L11,538@20715L37,540@20874L12,543@20965L33,546@21065L50,544@21003L244:NavigationDrawer.kt#uh7d8r"
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
            r4 = r37 & 2
            if (r4 == 0) goto L_0x003e
            r1 = r1 | 48
            r5 = r27
            goto L_0x0053
        L_0x003e:
            r5 = r13 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r27
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r1 = r1 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r27
        L_0x0053:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006c
            r6 = r37 & 4
            if (r6 != 0) goto L_0x0066
            r6 = r28
            boolean r8 = r14.changed((long) r6)
            if (r8 == 0) goto L_0x0068
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0066:
            r6 = r28
        L_0x0068:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r1 = r1 | r8
            goto L_0x006e
        L_0x006c:
            r6 = r28
        L_0x006e:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0087
            r8 = r37 & 8
            if (r8 != 0) goto L_0x0081
            r8 = r30
            boolean r10 = r14.changed((long) r8)
            if (r10 == 0) goto L_0x0083
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0081:
            r8 = r30
        L_0x0083:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r10
            goto L_0x0089
        L_0x0087:
            r8 = r30
        L_0x0089:
            r10 = r37 & 16
            r11 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0095
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r15 = r32
            goto L_0x00ab
        L_0x0095:
            r15 = r13 & r11
            if (r15 != 0) goto L_0x00a9
            r15 = r32
            boolean r16 = r14.changed((float) r15)
            if (r16 == 0) goto L_0x00a4
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r16
            goto L_0x00ab
        L_0x00a9:
            r15 = r32
        L_0x00ab:
            r16 = 458752(0x70000, float:6.42848E-40)
            r17 = r13 & r16
            if (r17 != 0) goto L_0x00c7
            r17 = r37 & 32
            if (r17 != 0) goto L_0x00c0
            r11 = r33
            boolean r17 = r14.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x00c2
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c0:
            r11 = r33
        L_0x00c2:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r17
            goto L_0x00c9
        L_0x00c7:
            r11 = r33
        L_0x00c9:
            r17 = r37 & 64
            r18 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00d4
            r17 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00e4
        L_0x00d4:
            r17 = r13 & r18
            if (r17 != 0) goto L_0x00e4
            boolean r17 = r14.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x00e1
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00e1:
            r17 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d1
        L_0x00e4:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r17
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x0108
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00f5
            goto L_0x0108
        L_0x00f5:
            r14.skipToGroupEnd()
            r16 = r1
            r17 = r5
            r20 = r6
            r22 = r8
            r25 = r11
            r24 = r15
            r15 = r26
            goto L_0x024c
        L_0x0108:
            r14.startDefaults()
            r0 = r13 & 1
            r3 = 6
            if (r0 == 0) goto L_0x014c
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0117
            goto L_0x014c
        L_0x0117:
            r14.skipToGroupEnd()
            r0 = r37 & 4
            if (r0 == 0) goto L_0x0120
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0120:
            r0 = r37 & 8
            if (r0 == 0) goto L_0x0126
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0126:
            r0 = r37 & 32
            if (r0 == 0) goto L_0x013d
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
            r17 = r5
            r20 = r6
            r22 = r8
            r25 = r11
            r24 = r15
            r15 = r26
            r11 = r0
            goto L_0x01aa
        L_0x013d:
            r17 = r5
            r20 = r6
            r22 = r8
            r25 = r11
            r24 = r15
            r15 = r26
            r11 = r1
            goto L_0x01aa
        L_0x014c:
            if (r2 == 0) goto L_0x0153
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0155
        L_0x0153:
            r0 = r26
        L_0x0155:
            if (r4 == 0) goto L_0x015c
            androidx.compose.ui.graphics.Shape r2 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r5 = r2
        L_0x015c:
            r2 = r37 & 4
            if (r2 == 0) goto L_0x016c
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r14, r3)
            long r6 = r2.m1818getSurface0d7_KjU()
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x016c:
            r2 = r37 & 8
            if (r2 == 0) goto L_0x017a
            int r2 = r1 >> 6
            r2 = r2 & 14
            long r8 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r6, r14, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x017a:
            if (r10 == 0) goto L_0x0183
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1898getPermanentDrawerElevationD9Ej5fM()
            r15 = r2
        L_0x0183:
            r2 = r37 & 32
            if (r2 == 0) goto L_0x019e
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r14, r3)
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            r11 = r1
            r25 = r2
            r17 = r5
            r20 = r6
            r22 = r8
            r24 = r15
            r15 = r0
            goto L_0x01aa
        L_0x019e:
            r17 = r5
            r20 = r6
            r22 = r8
            r25 = r11
            r24 = r15
            r15 = r0
            r11 = r1
        L_0x01aa:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01bc
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:534)"
            r2 = -1733353241(0xffffffff98af20e7, float:-4.5269663E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r0, r1)
        L_0x01bc:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2086getNavigationMenuadMyvUU()
            java.lang.String r10 = androidx.compose.material3.Strings_androidKt.m2089getStringNWtq28(r0, r14, r3)
            r0 = 0
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            boolean r2 = r14.changed((java.lang.Object) r10)
            r3 = r14
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x01ec
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x01ea
            goto L_0x01ec
        L_0x01ea:
            r7 = r5
            goto L_0x01f9
        L_0x01ec:
            r7 = 0
            androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1 r8 = new androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
            r8.<init>(r10)
            r7 = r8
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r3.updateRememberedValue(r7)
        L_0x01f9:
            r14.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r0 = 0
            r1 = 0
            r2 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r15, r1, r7, r2, r0)
            int r0 = r11 >> 15
            r0 = r0 & 14
            int r2 = r11 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r11 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r11 << 3
            r3 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r11 << 3
            r2 = r2 & r16
            r0 = r0 | r2
            r2 = r11 & r18
            r16 = r0 | r2
            r18 = 0
            r0 = r25
            r2 = r17
            r3 = r20
            r5 = r22
            r7 = r24
            r8 = r34
            r9 = r14
            r19 = r10
            r10 = r16
            r16 = r11
            r11 = r18
            m2007DrawerSheetvywBR7E(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x024c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x024c:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x0253
            goto L_0x0273
        L_0x0253:
            androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2 r18 = new androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2
            r0 = r18
            r1 = r15
            r2 = r17
            r3 = r20
            r5 = r22
            r7 = r24
            r8 = r25
            r9 = r34
            r10 = r36
            r12 = r11
            r11 = r37
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0273:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2010PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0100  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: DrawerSheet-vywBR7E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2007DrawerSheetvywBR7E(androidx.compose.foundation.layout.WindowInsets r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r12 = r28
            r13 = r36
            r14 = r38
            r0 = 175072821(0xa6f6635, float:1.15266544E-32)
            r1 = r37
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DrawerSheet)P(6,5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp)563@21470L11,564@21523L37,568@21690L667:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r38
            r2 = r39 & 1
            if (r2 == 0) goto L_0x001d
            r1 = r1 | 6
            goto L_0x002b
        L_0x001d:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x002b
            boolean r2 = r11.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r1 = r1 | r2
        L_0x002b:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            r3 = r29
            goto L_0x0049
        L_0x0034:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0047
            r3 = r29
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0043
            r4 = 32
            goto L_0x0045
        L_0x0043:
            r4 = 16
        L_0x0045:
            r1 = r1 | r4
            goto L_0x0049
        L_0x0047:
            r3 = r29
        L_0x0049:
            r4 = r39 & 4
            if (r4 == 0) goto L_0x0052
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r30
            goto L_0x0067
        L_0x0052:
            r5 = r14 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0065
            r5 = r30
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0061
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r6
            goto L_0x0067
        L_0x0065:
            r5 = r30
        L_0x0067:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0080
            r6 = r39 & 8
            if (r6 != 0) goto L_0x007a
            r6 = r31
            boolean r8 = r11.changed((long) r6)
            if (r8 == 0) goto L_0x007c
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007a:
            r6 = r31
        L_0x007c:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r1 = r1 | r8
            goto L_0x0082
        L_0x0080:
            r6 = r31
        L_0x0082:
            r8 = 57344(0xe000, float:8.0356E-41)
            r9 = r14 & r8
            if (r9 != 0) goto L_0x009e
            r9 = r39 & 16
            if (r9 != 0) goto L_0x0098
            r9 = r33
            boolean r15 = r11.changed((long) r9)
            if (r15 == 0) goto L_0x009a
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x0098:
            r9 = r33
        L_0x009a:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r1 = r1 | r15
            goto L_0x00a0
        L_0x009e:
            r9 = r33
        L_0x00a0:
            r15 = r39 & 32
            if (r15 == 0) goto L_0x00ab
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r8 = r35
            goto L_0x00c3
        L_0x00ab:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00c1
            r8 = r35
            boolean r16 = r11.changed((float) r8)
            if (r16 == 0) goto L_0x00bc
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r1 = r1 | r16
            goto L_0x00c3
        L_0x00c1:
            r8 = r35
        L_0x00c3:
            r16 = r39 & 64
            if (r16 == 0) goto L_0x00cc
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c9:
            r1 = r1 | r16
            goto L_0x00de
        L_0x00cc:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00de
            boolean r16 = r11.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00db
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c9
        L_0x00db:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c9
        L_0x00de:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r16
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x0100
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x00ef
            goto L_0x0100
        L_0x00ef:
            r11.skipToGroupEnd()
            r15 = r29
            r22 = r1
            r16 = r5
            r17 = r6
            r21 = r8
            r19 = r9
            goto L_0x01eb
        L_0x0100:
            r11.startDefaults()
            r0 = r14 & 1
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0127
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0111
            goto L_0x0127
        L_0x0111:
            r11.skipToGroupEnd()
            r0 = r39 & 8
            if (r0 == 0) goto L_0x011a
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x011a:
            r0 = r39 & 16
            if (r0 == 0) goto L_0x0124
            r0 = r1 & r3
            r1 = r0
            r0 = r29
            goto L_0x015e
        L_0x0124:
            r0 = r29
            goto L_0x015e
        L_0x0127:
            if (r2 == 0) goto L_0x012e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0130
        L_0x012e:
            r0 = r29
        L_0x0130:
            if (r4 == 0) goto L_0x0137
            androidx.compose.ui.graphics.Shape r2 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r5 = r2
        L_0x0137:
            r2 = r39 & 8
            if (r2 == 0) goto L_0x0148
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r11, r4)
            long r6 = r2.m1818getSurface0d7_KjU()
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0148:
            r2 = r39 & 16
            if (r2 == 0) goto L_0x0155
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r9 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r6, r11, r2)
            r1 = r1 & r3
        L_0x0155:
            if (r15 == 0) goto L_0x015e
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1898getPermanentDrawerElevationD9Ej5fM()
            r8 = r2
        L_0x015e:
            r11.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0170
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:559)"
            r4 = 175072821(0xa6f6635, float:1.15266544E-32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x0170:
            float r2 = MinimumDrawerWidth
            r3 = 0
            androidx.compose.material3.DrawerDefaults r4 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r4 = r4.m1896getMaximumDrawerWidthD9Ej5fM()
            r15 = 0
            r16 = 10
            r17 = 0
            r29 = r0
            r30 = r2
            r31 = r3
            r32 = r4
            r33 = r15
            r34 = r16
            r35 = r17
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m834sizeInqDBjuR0$default(r29, r30, r31, r32, r33, r34, r35)
            r4 = 0
            r15 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r2, r3, r15, r4)
            r22 = 0
            r23 = 0
            androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1 r3 = new androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
            r3.<init>(r12, r13, r1)
            r4 = 959363152(0x392eb850, float:1.6662595E-4)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r4, r15, r3)
            r24 = r3
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            int r3 = r1 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r4 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r4
            int r4 = r1 >> 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            int r4 = r1 >> 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            int r4 = r1 >> 3
            r15 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r15
            r26 = r3 | r4
            r27 = 96
            r15 = r2
            r16 = r5
            r17 = r6
            r19 = r9
            r21 = r8
            r25 = r11
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r27)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01e0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e0:
            r15 = r0
            r22 = r1
            r16 = r5
            r17 = r6
            r21 = r8
            r19 = r9
        L_0x01eb:
            androidx.compose.runtime.ScopeUpdateScope r10 = r11.endRestartGroup()
            if (r10 != 0) goto L_0x01f4
            r24 = r11
            goto L_0x0216
        L_0x01f4:
            androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2 r23 = new androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
            r0 = r23
            r1 = r28
            r2 = r15
            r3 = r16
            r4 = r17
            r6 = r19
            r8 = r21
            r9 = r36
            r12 = r10
            r10 = r38
            r24 = r11
            r11 = r39
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0216:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2007DrawerSheetvywBR7E(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @ExperimentalMaterial3Api
    public static final void NavigationDrawerItem(Function2<? super Composer, ? super Integer, Unit> label, boolean selected, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> badge, Shape shape, NavigationDrawerItemColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Function2 icon2;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource;
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        NavigationDrawerItemColors colors2;
        Function2 badge2;
        Function2 icon3;
        int $dirty;
        Shape shape3;
        Function2 badge3;
        Modifier modifier3;
        MutableInteractionSource interactionSource3;
        NavigationDrawerItemColors colors3;
        NavigationDrawerItemColors colors4;
        MutableInteractionSource mutableInteractionSource2;
        int i2;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function2 = label;
        boolean z = selected;
        Function0<Unit> function0 = onClick;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(function2, "label");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1304626543);
        ComposerKt.sourceInformation($composer2, "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)666@25487L9,667@25568L8,668@25628L39,677@25910L24,670@25676L1203:NavigationDrawer.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i5 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer2.changed((Object) function2) ? 4 : 2;
        }
        if ((i5 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer2.changed(z) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            $dirty2 |= 384;
        } else if ((i4 & 896) == 0) {
            $dirty2 |= $composer2.changed((Object) function0) ? 256 : 128;
        }
        int i6 = i5 & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            Modifier modifier4 = modifier;
        } else if ((i4 & 7168) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 2048 : 1024;
        } else {
            Modifier modifier5 = modifier;
        }
        int i7 = i5 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            icon2 = icon;
        } else if ((i4 & 57344) == 0) {
            icon2 = icon;
            $dirty2 |= $composer2.changed((Object) icon2) ? 16384 : 8192;
        } else {
            icon2 = icon;
        }
        int i8 = i5 & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function2<? super Composer, ? super Integer, Unit> function22 = badge;
        } else if ((458752 & i4) == 0) {
            $dirty2 |= $composer2.changed((Object) badge) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = badge;
        }
        if ((3670016 & i4) == 0) {
            if ((i5 & 64) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i3 = 1048576;
                    $dirty2 |= i3;
                }
            } else {
                shape2 = shape;
            }
            i3 = 524288;
            $dirty2 |= i3;
        } else {
            shape2 = shape;
        }
        if ((i4 & 29360128) == 0) {
            if ((i5 & 128) != 0) {
                NavigationDrawerItemColors navigationDrawerItemColors = colors;
            } else if ($composer2.changed((Object) colors)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            NavigationDrawerItemColors navigationDrawerItemColors2 = colors;
        }
        int i9 = i5 & 256;
        if (i9 != 0) {
            $dirty2 |= 100663296;
            mutableInteractionSource = interactionSource;
        } else if ((i4 & 234881024) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed((Object) mutableInteractionSource) ? 67108864 : 33554432;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($dirty2 & 191739611) != 38347922 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i7 != 0) {
                    icon2 = null;
                }
                if (i8 != 0) {
                    badge3 = null;
                } else {
                    badge3 = badge;
                }
                if ((i5 & 64) != 0) {
                    shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), $composer2, 6);
                    $dirty2 &= -3670017;
                } else {
                    shape3 = shape2;
                }
                if ((i5 & 128) != 0) {
                    colors4 = NavigationDrawerItemDefaults.INSTANCE.m2005colorsoq7We08(0, 0, 0, 0, 0, 0, 0, 0, $composer2, 100663296, 255);
                    $dirty2 &= -29360129;
                } else {
                    colors4 = colors;
                }
                if (i9 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource2);
                    } else {
                        mutableInteractionSource2 = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    $dirty = $dirty3;
                    interactionSource3 = mutableInteractionSource2;
                    colors3 = colors4;
                } else {
                    $dirty = $dirty2;
                    interactionSource3 = interactionSource;
                    colors3 = colors4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i5 & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i5 & 128) != 0) {
                    modifier3 = modifier;
                    badge3 = badge;
                    $dirty = $dirty2 & -29360129;
                    interactionSource3 = mutableInteractionSource;
                    shape3 = shape2;
                    colors3 = colors;
                } else {
                    modifier3 = modifier;
                    badge3 = badge;
                    colors3 = colors;
                    $dirty = $dirty2;
                    interactionSource3 = mutableInteractionSource;
                    shape3 = shape2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1304626543, $dirty, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:659)");
            }
            modifier2 = modifier3;
            SurfaceKt.m2098Surfaced85dljk(selected, onClick, SizeKt.fillMaxWidth$default(SizeKt.m816height3ABfNKs(modifier3, NavigationDrawerTokens.INSTANCE.m2523getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, (Object) null), false, shape3, colors3.containerColor(z, $composer2, (($dirty >> 3) & 14) | (($dirty >> 18) & 112)).getValue().m3174unboximpl(), 0, 0.0f, 0.0f, (BorderStroke) null, interactionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 191488423, true, new NavigationDrawerKt$NavigationDrawerItem$2(icon2, colors3, selected, $dirty, badge3, label)), $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 6) & 57344), (($dirty >> 24) & 14) | 48, 968);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors2 = colors3;
            interactionSource2 = interactionSource3;
            badge2 = badge3;
            shape2 = shape3;
            int i10 = $dirty;
            icon3 = icon2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            colors2 = colors;
            int i11 = $dirty2;
            icon3 = icon2;
            interactionSource2 = mutableInteractionSource;
            badge2 = badge;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new NavigationDrawerKt$NavigationDrawerItem$3(label, selected, onClick, modifier2, icon3, badge2, shape2, colors2, interactionSource2, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final float calculateFraction(float a, float b, float pos) {
        return RangesKt.coerceIn((pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a4  */
    /* renamed from: Scrim-Bx497Mc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2011ScrimBx497Mc(boolean r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23, kotlin.jvm.functions.Function0<java.lang.Float> r24, long r25, androidx.compose.runtime.Composer r27, int r28) {
        /*
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r12 = r28
            r0 = 2106487387(0x7d8e725b, float:2.3668018E37)
            r1 = r27
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)860@33035L30,876@33479L51,872@33388L142:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r28
            r2 = r12 & 14
            if (r2 != 0) goto L_0x0028
            boolean r2 = r13.changed((boolean) r7)
            if (r2 == 0) goto L_0x0026
            r2 = 4
            goto L_0x0027
        L_0x0026:
            r2 = 2
        L_0x0027:
            r1 = r1 | r2
        L_0x0028:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0038
            boolean r2 = r13.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0035
            r2 = 32
            goto L_0x0037
        L_0x0035:
            r2 = 16
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r12 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0048
            boolean r2 = r13.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x0045
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0047
        L_0x0045:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0058
            boolean r2 = r13.changed((long) r10)
            if (r2 == 0) goto L_0x0055
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0057
        L_0x0055:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0057:
            r1 = r1 | r2
        L_0x0058:
            r14 = r1
            r1 = r14 & 5851(0x16db, float:8.199E-42)
            r2 = 1170(0x492, float:1.64E-42)
            if (r1 != r2) goto L_0x006b
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x0066
            goto L_0x006b
        L_0x0066:
            r13.skipToGroupEnd()
            goto L_0x01a7
        L_0x006b:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0077
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.Scrim (NavigationDrawer.kt:854)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x0077:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2079getCloseDraweradMyvUU()
            r1 = 6
            java.lang.String r0 = androidx.compose.material3.Strings_androidKt.m2089getStringNWtq28(r0, r13, r1)
            r1 = -1858703137(0xffffffff913670df, float:-1.439205E-28)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "863@33154L35,864@33238L108"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            java.lang.String r1 = "C(remember)P(1,2):Composables.kt#9igjgp"
            if (r7 == 0) goto L_0x0130
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            int r6 = r14 >> 3
            r6 = r6 & 14
            r6 = r6 | 64
            r15 = 0
            r4 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            boolean r4 = r13.changed((java.lang.Object) r8)
            r16 = r13
            r17 = 0
            java.lang.Object r2 = r16.rememberedValue()
            r19 = 0
            if (r4 != 0) goto L_0x00c5
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r20.getEmpty()
            if (r2 != r3) goto L_0x00c0
            goto L_0x00c5
        L_0x00c0:
            r20 = r2
            r3 = r16
            goto L_0x00d8
        L_0x00c5:
            r3 = 0
            r20 = r2
            androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$1$1 r2 = new androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$1$1
            r21 = r3
            r3 = 0
            r2.<init>(r8, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = r16
            r3.updateRememberedValue(r2)
        L_0x00d8:
            r13.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r5, (java.lang.Object) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r2)
            r3 = r14 & 112(0x70, float:1.57E-43)
            r4 = 0
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r5 = r13.changed((java.lang.Object) r0)
            boolean r6 = r13.changed((java.lang.Object) r8)
            r5 = r5 | r6
            r6 = r13
            r15 = 0
            r16 = r3
            java.lang.Object r3 = r6.rememberedValue()
            r17 = 0
            if (r5 != 0) goto L_0x0113
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r4
            java.lang.Object r4 = r19.getEmpty()
            if (r3 != r4) goto L_0x0110
            goto L_0x0115
        L_0x0110:
            r19 = r3
            goto L_0x0123
        L_0x0113:
            r20 = r4
        L_0x0115:
            r4 = 0
            r19 = r3
            androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1 r3 = new androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1
            r3.<init>(r0, r8)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r6.updateRememberedValue(r3)
        L_0x0123:
            r13.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r2, r4, r3)
            goto L_0x0134
        L_0x0130:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
        L_0x0134:
            r13.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 0
            r5 = 0
            r6 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r3, r4, r6, r5)
            androidx.compose.ui.Modifier r3 = r3.then(r2)
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3154boximpl(r25)
            int r5 = r14 >> 9
            r5 = r5 & 14
            int r6 = r14 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            r6 = 0
            r15 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r1 = r13.changed((java.lang.Object) r4)
            boolean r15 = r13.changed((java.lang.Object) r9)
            r1 = r1 | r15
            r15 = r13
            r16 = 0
            r27 = r0
            java.lang.Object r0 = r15.rememberedValue()
            r17 = 0
            if (r1 != 0) goto L_0x0183
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x0180
            goto L_0x0185
        L_0x0180:
            r18 = r0
            goto L_0x0193
        L_0x0183:
            r19 = r1
        L_0x0185:
            r1 = 0
            r18 = r0
            androidx.compose.material3.NavigationDrawerKt$Scrim$1$1 r0 = new androidx.compose.material3.NavigationDrawerKt$Scrim$1$1
            r0.<init>(r10, r9)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r15.updateRememberedValue(r0)
        L_0x0193:
            r13.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r3, r0, r13, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a7:
            androidx.compose.runtime.ScopeUpdateScope r15 = r13.endRestartGroup()
            if (r15 != 0) goto L_0x01ae
            goto L_0x01c6
        L_0x01ae:
            androidx.compose.material3.NavigationDrawerKt$Scrim$2 r16 = new androidx.compose.material3.NavigationDrawerKt$Scrim$2
            r0 = r16
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r6 = r28
            r0.<init>(r1, r2, r3, r4, r6)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x01c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2011ScrimBx497Mc(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, long, androidx.compose.runtime.Composer, int):void");
    }
}
