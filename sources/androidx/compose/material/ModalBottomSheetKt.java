package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u001a\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001aq\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000b\u001a\u00020\u001226\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u00042!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00180\u001aH\u0002\u001a\u0001\u0010\u001b\u001a\u00020\u00182\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u00072\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020&2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00180*¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a@\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00112\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0006002\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002020\u001a2\b\b\u0002\u00103\u001a\u000202H\u0007\u001a3\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020&2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00180*2\u0006\u00107\u001a\u000202H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a9\u0010:\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00112\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0006002\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002020\u001aH\u0007¢\u0006\u0002\u0010<\u001aE\u0010:\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00112\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0006002\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002020\u001a2\b\b\u0002\u0010=\u001a\u000202H\u0007¢\u0006\u0002\u0010>\u001aA\u0010:\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00112\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0006002\u0006\u0010=\u001a\u0002022\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002020\u001aH\u0007¢\u0006\u0002\u0010?\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"%\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"MaxModalBottomSheetWidth", "Landroidx/compose/ui/unit/Dp;", "F", "PositionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ExtensionFunctionType;", "VelocityThreshold", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/SwipeableV2State;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "ModalBottomSheetAnchorChangeHandler", "Landroidx/compose/material/AnchorChangeHandler;", "Landroidx/compose/material/ModalBottomSheetValue;", "Landroidx/compose/material/ModalBottomSheetState;", "animateTo", "Lkotlin/ParameterName;", "name", "target", "velocity", "", "snapTo", "Lkotlin/Function1;", "ModalBottomSheetLayout", "sheetContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-BzaUkTc", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;Landroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalBottomSheetState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "", "isSkipHalfExpanded", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "confirmStateChange", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
public final class ModalBottomSheetKt {
    /* access modifiers changed from: private */
    public static final float MaxModalBottomSheetWidth = Dp.m5986constructorimpl((float) 640);
    /* access modifiers changed from: private */
    public static final Function2<Density, Float, Float> PositionalThreshold = ModalBottomSheetKt$PositionalThreshold$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final float VelocityThreshold = Dp.m5986constructorimpl((float) 125);

    public static /* synthetic */ ModalBottomSheetState ModalBottomSheetState$default(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 4) != 0) {
            function1 = ModalBottomSheetKt$ModalBottomSheetState$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return ModalBottomSheetState(modalBottomSheetValue, animationSpec, function1, z);
    }

    public static final ModalBottomSheetState ModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, boolean isSkipHalfExpanded) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        return new ModalBottomSheetState(initialValue, animationSpec, isSkipHalfExpanded, confirmValueChange);
    }

    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, boolean skipHalfExpanded, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-126412120);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2):ModalBottomSheet.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange2 = confirmValueChange;
        if ((i & 4) != 0) {
            confirmValueChange2 = ModalBottomSheetKt$rememberModalBottomSheetState$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            skipHalfExpanded = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126412120, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:313)");
        }
        $composer.startMovableGroup(170046719, initialValue);
        ComposerKt.sourceInformation($composer, "323@13170L567");
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{initialValue, animationSpec2, Boolean.valueOf(skipHalfExpanded), confirmValueChange2}, ModalBottomSheetState.Companion.Saver(animationSpec2, confirmValueChange2, skipHalfExpanded), (String) null, new ModalBottomSheetKt$rememberModalBottomSheetState$2(initialValue, animationSpec2, confirmValueChange2, skipHalfExpanded), $composer, 72, 4);
        $composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, false)", imports = {}))
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, boolean skipHalfExpanded, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        $composer.startReplaceableGroup(-409288536);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2!1,3)367@15133L185:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-409288536, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:362)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, skipHalfExpanded, $composer, ($changed & 14) | 64 | (($changed >> 3) & 896) | (($changed << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "rememberModalBottomSheetState(initialValue, animationSpec, confirmValueChange = confirmStateChange)", imports = {}))
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        $composer.startReplaceableGroup(-1928569212);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2)393@16184L174:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1928569212, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:389)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, false, $composer, ($changed & 14) | 3136 | ($changed & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:159:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0130  */
    /* renamed from: ModalBottomSheetLayout-BzaUkTc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1542ModalBottomSheetLayoutBzaUkTc(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.ui.Modifier r35, androidx.compose.material.ModalBottomSheetState r36, androidx.compose.ui.graphics.Shape r37, float r38, long r39, long r41, long r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, int r47, int r48) {
        /*
            r15 = r34
            r14 = r45
            r12 = r47
            r13 = r48
            java.lang.String r0 = "sheetContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1633763156(0xffffffff9e9ec0ac, float:-1.6808588E-20)
            r1 = r46
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ModalBottomSheetLayout)P(4,1,8,7,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color)434@18223L37,435@18300L6,437@18423L6,438@18470L37,439@18558L10,442@18626L24,444@18724L344,453@19073L3836:ModalBottomSheet.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r47
            r2 = r13 & 1
            r3 = 4
            if (r2 == 0) goto L_0x002b
            r1 = r1 | 6
            goto L_0x0039
        L_0x002b:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x0039
            boolean r2 = r11.changedInstance(r15)
            if (r2 == 0) goto L_0x0037
            r2 = r3
            goto L_0x0038
        L_0x0037:
            r2 = 2
        L_0x0038:
            r1 = r1 | r2
        L_0x0039:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x0042
            r1 = r1 | 48
            r4 = r35
            goto L_0x0057
        L_0x0042:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0055
            r4 = r35
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0051
            r5 = 32
            goto L_0x0053
        L_0x0051:
            r5 = 16
        L_0x0053:
            r1 = r1 | r5
            goto L_0x0057
        L_0x0055:
            r4 = r35
        L_0x0057:
            r5 = r13 & 4
            if (r5 == 0) goto L_0x005d
            r1 = r1 | 128(0x80, float:1.794E-43)
        L_0x005d:
            r6 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0076
            r6 = r13 & 8
            if (r6 != 0) goto L_0x0070
            r8 = r37
            boolean r6 = r11.changed((java.lang.Object) r8)
            if (r6 == 0) goto L_0x0072
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0074
        L_0x0070:
            r8 = r37
        L_0x0072:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0074:
            r1 = r1 | r6
            goto L_0x0078
        L_0x0076:
            r8 = r37
        L_0x0078:
            r9 = r13 & 16
            if (r9 == 0) goto L_0x0081
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = r38
            goto L_0x0098
        L_0x0081:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r12
            if (r6 != 0) goto L_0x0096
            r10 = r38
            boolean r6 = r11.changed((float) r10)
            if (r6 == 0) goto L_0x0092
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r1 = r1 | r6
            goto L_0x0098
        L_0x0096:
            r10 = r38
        L_0x0098:
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r12
            if (r6 != 0) goto L_0x00b3
            r6 = r13 & 32
            if (r6 != 0) goto L_0x00ac
            r6 = r39
            boolean r16 = r11.changed((long) r6)
            if (r16 == 0) goto L_0x00ae
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ac:
            r6 = r39
        L_0x00ae:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r1 = r1 | r16
            goto L_0x00b5
        L_0x00b3:
            r6 = r39
        L_0x00b5:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d0
            r16 = r13 & 64
            if (r16 != 0) goto L_0x00ca
            r7 = r41
            boolean r6 = r11.changed((long) r7)
            if (r6 == 0) goto L_0x00cc
            r6 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00ca:
            r7 = r41
        L_0x00cc:
            r6 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r1 = r1 | r6
            goto L_0x00d2
        L_0x00d0:
            r7 = r41
        L_0x00d2:
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r12
            if (r6 != 0) goto L_0x00ec
            r6 = r13 & 128(0x80, float:1.794E-43)
            if (r6 != 0) goto L_0x00e6
            r7 = r43
            boolean r6 = r11.changed((long) r7)
            if (r6 == 0) goto L_0x00e8
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e6:
            r7 = r43
        L_0x00e8:
            r6 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r1 = r1 | r6
            goto L_0x00ee
        L_0x00ec:
            r7 = r43
        L_0x00ee:
            r6 = r13 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x00f6
            r6 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x00f4:
            r1 = r1 | r6
            goto L_0x0107
        L_0x00f6:
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r12
            if (r6 != 0) goto L_0x0107
            boolean r6 = r11.changedInstance(r14)
            if (r6 == 0) goto L_0x0104
            r6 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00f4
        L_0x0104:
            r6 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00f4
        L_0x0107:
            r6 = r1
            if (r5 != r3) goto L_0x0130
            r1 = 191739611(0xb6db6db, float:4.5782105E-32)
            r1 = r1 & r6
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r3) goto L_0x0130
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x011a
            goto L_0x0130
        L_0x011a:
            r11.skipToGroupEnd()
            r32 = r36
            r16 = r37
            r20 = r39
            r23 = r41
            r19 = r4
            r31 = r6
            r25 = r7
            r17 = r10
            r15 = r11
            goto L_0x033b
        L_0x0130:
            r11.startDefaults()
            r1 = r12 & 1
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r1 == 0) goto L_0x0188
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0147
            goto L_0x0188
        L_0x0147:
            r11.skipToGroupEnd()
            if (r5 == 0) goto L_0x014e
            r6 = r6 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014e:
            r1 = r13 & 8
            if (r1 == 0) goto L_0x0154
            r6 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0154:
            r1 = r13 & 32
            if (r1 == 0) goto L_0x015a
            r6 = r6 & r18
        L_0x015a:
            r1 = r13 & 64
            if (r1 == 0) goto L_0x0160
            r6 = r6 & r17
        L_0x0160:
            r1 = r13 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0177
            r1 = r6 & r16
            r16 = r37
            r20 = r39
            r23 = r41
            r9 = r1
            r19 = r4
            r25 = r7
            r17 = r10
            r10 = r36
            goto L_0x0217
        L_0x0177:
            r16 = r37
            r20 = r39
            r23 = r41
            r19 = r4
            r9 = r6
            r25 = r7
            r17 = r10
            r10 = r36
            goto L_0x0217
        L_0x0188:
            if (r2 == 0) goto L_0x0191
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r19 = r1
            goto L_0x0193
        L_0x0191:
            r19 = r4
        L_0x0193:
            if (r5 == 0) goto L_0x01ab
            androidx.compose.material.ModalBottomSheetValue r1 = androidx.compose.material.ModalBottomSheetValue.Hidden
            r2 = 0
            r3 = 0
            r4 = 0
            r20 = 6
            r21 = 14
            r5 = r11
            r0 = r6
            r6 = r20
            r7 = r21
            androidx.compose.material.ModalBottomSheetState r1 = rememberModalBottomSheetState((androidx.compose.material.ModalBottomSheetValue) r1, (androidx.compose.animation.core.AnimationSpec<java.lang.Float>) r2, (kotlin.jvm.functions.Function1<? super androidx.compose.material.ModalBottomSheetValue, java.lang.Boolean>) r3, (boolean) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r6 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01ae
        L_0x01ab:
            r0 = r6
            r1 = r36
        L_0x01ae:
            r0 = r13 & 8
            r2 = 6
            if (r0 == 0) goto L_0x01c2
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r0 = r0.getShapes(r11, r2)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getLarge()
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            r6 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01c4
        L_0x01c2:
            r0 = r37
        L_0x01c4:
            if (r9 == 0) goto L_0x01cd
            androidx.compose.material.ModalBottomSheetDefaults r3 = androidx.compose.material.ModalBottomSheetDefaults.INSTANCE
            float r3 = r3.m1541getElevationD9Ej5fM()
            goto L_0x01ce
        L_0x01cd:
            r3 = r10
        L_0x01ce:
            r4 = r13 & 32
            if (r4 == 0) goto L_0x01df
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r4 = r4.getColors(r11, r2)
            long r4 = r4.m1449getSurface0d7_KjU()
            r6 = r6 & r18
            goto L_0x01e1
        L_0x01df:
            r4 = r39
        L_0x01e1:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x01f0
            int r7 = r6 >> 15
            r7 = r7 & 14
            long r7 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r4, r11, r7)
            r6 = r6 & r17
            goto L_0x01f2
        L_0x01f0:
            r7 = r41
        L_0x01f2:
            r9 = r13 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x020b
            androidx.compose.material.ModalBottomSheetDefaults r9 = androidx.compose.material.ModalBottomSheetDefaults.INSTANCE
            long r9 = r9.getScrimColor(r11, r2)
            r2 = r6 & r16
            r16 = r0
            r17 = r3
            r20 = r4
            r23 = r7
            r25 = r9
            r10 = r1
            r9 = r2
            goto L_0x0217
        L_0x020b:
            r25 = r43
            r16 = r0
            r10 = r1
            r17 = r3
            r20 = r4
            r9 = r6
            r23 = r7
        L_0x0217:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0229
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:430)"
            r2 = -1633763156(0xffffffff9e9ec0ac, float:-1.6808588E-20)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r9, r0, r1)
        L_0x0229:
            r0 = 0
            r1 = r0
            r2 = 0
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            r3 = r11
            r4 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r5 = 0
            r6 = r11
            r7 = 0
            java.lang.Object r8 = r6.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r35 = r0
            java.lang.Object r0 = r22.getEmpty()
            if (r8 != r0) goto L_0x0277
            r0 = 0
            r22 = 0
            kotlin.coroutines.EmptyCoroutineContext r22 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r36 = r0
            r0 = r22
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r3)
            r37 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r0 = r1
            r6.updateRememberedValue(r0)
            goto L_0x027a
        L_0x0277:
            r37 = r1
            r0 = r8
        L_0x027a:
            r11.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r1 = r0.getCoroutineScope()
            r11.endReplaceableGroup()
            r7 = r1
            androidx.compose.foundation.gestures.Orientation r18 = androidx.compose.foundation.gestures.Orientation.Vertical
            r0 = 72
            r1 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            boolean r2 = r11.changed((java.lang.Object) r10)
            boolean r3 = r11.changed((java.lang.Object) r7)
            r2 = r2 | r3
            r3 = r11
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x02bb
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x02b5
            goto L_0x02bb
        L_0x02b5:
            r35 = r0
            r36 = r1
            r0 = r5
            goto L_0x02d8
        L_0x02bb:
            r8 = 0
            r35 = r0
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$anchorChangeHandler$1$1 r0 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$anchorChangeHandler$1$1
            r0.<init>(r7, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r36 = r1
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$anchorChangeHandler$1$2 r1 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$anchorChangeHandler$1$2
            r1.<init>(r7, r10)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.material.AnchorChangeHandler r0 = ModalBottomSheetAnchorChangeHandler(r10, r0, r1)
            r3.updateRememberedValue(r0)
        L_0x02d8:
            r11.endReplaceableGroup()
            r22 = r0
            androidx.compose.material.AnchorChangeHandler r22 = (androidx.compose.material.AnchorChangeHandler) r22
            r27 = 0
            r28 = 0
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1 r8 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
            r0 = r8
            r1 = r10
            r2 = r18
            r3 = r22
            r4 = r16
            r5 = r20
            r29 = r7
            r30 = r8
            r7 = r23
            r31 = r9
            r9 = r17
            r32 = r10
            r10 = r31
            r33 = r11
            r11 = r45
            r12 = r25
            r14 = r29
            r15 = r34
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r14, r15)
            r0 = 1607356310(0x5fce4f96, float:2.9732532E19)
            r1 = 1
            r2 = r30
            r15 = r33
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r1, r2)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            int r1 = r31 >> 3
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r2 = 6
            r35 = r19
            r36 = r27
            r37 = r28
            r38 = r0
            r39 = r15
            r40 = r1
            r41 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r35, r36, r37, r38, r39, r40, r41)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x033b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x033b:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x0344
            r33 = r15
            goto L_0x036b
        L_0x0344:
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2 r18 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
            r0 = r18
            r1 = r34
            r2 = r19
            r3 = r32
            r4 = r16
            r5 = r17
            r6 = r20
            r8 = r23
            r10 = r25
            r12 = r45
            r13 = r47
            r33 = r15
            r15 = r14
            r14 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r12, r13, r14)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x036b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.m1542ModalBottomSheetLayoutBzaUkTc(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m1543Scrim3JVO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        Modifier dismissModifier;
        Object value$iv$iv;
        Object value$iv$iv2;
        long j = color;
        Function0<Unit> function0 = onDismiss;
        boolean z = visible;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-526532668);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)553@23064L121,557@23211L29,573@23726L62,569@23617L171:ModalBottomSheet.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-526532668, $dirty2, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:547)");
            }
            if (color != Color.Companion.m3200getUnspecified0d7_KjU()) {
                State alpha$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (Function1) null, $composer2, 48, 12);
                String closeSheet = Strings_androidKt.m1618getString4foXLRw(Strings.Companion.m1612getCloseSheetUdPEhr4(), $composer2, 6);
                $composer2.startReplaceableGroup(1010553415);
                ComposerKt.sourceInformation($composer2, "560@23348L37,561@23438L121");
                if (z) {
                    Modifier modifier = Modifier.Companion;
                    int i2 = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed((Object) function0);
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = (Function2) new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, (Continuation<? super ModalBottomSheetKt$Scrim$dismissModifier$1$1>) null);
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Composer composer = $this$cache$iv$iv;
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv);
                    int $changed$iv = $dirty2 & 112;
                    $composer2.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer2.changed((Object) closeSheet) | $composer2.changed((Object) function0);
                    Composer $this$cache$iv$iv2 = $composer2;
                    Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                    if (!invalid$iv$iv2) {
                        int i3 = $changed$iv;
                        if (it$iv$iv2 != Composer.Companion.getEmpty()) {
                            value$iv$iv2 = it$iv$iv2;
                            $composer2.endReplaceableGroup();
                            dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                        }
                    }
                    value$iv$iv2 = (Function1) new ModalBottomSheetKt$Scrim$dismissModifier$2$1(closeSheet, function0);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                    $composer2.endReplaceableGroup();
                    dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                } else {
                    dismissModifier = Modifier.Companion;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(dismissModifier);
                Object r2 = Color.m3154boximpl(color);
                int i4 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv3 = $composer2.changed(r2) | $composer2.changed((Object) alpha$delegate);
                Composer $this$cache$iv$iv3 = $composer2;
                Modifier modifier2 = dismissModifier;
                Object value$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
                if (!invalid$iv$iv3) {
                    Color color2 = r2;
                    if (value$iv$iv3 != Composer.Companion.getEmpty()) {
                        Object obj = value$iv$iv3;
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
                    }
                } else {
                    Object key1$iv = r2;
                }
                Object obj2 = value$iv$iv3;
                value$iv$iv3 = new ModalBottomSheetKt$Scrim$1$1(j, alpha$delegate);
                $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i5 = $dirty2;
            Composer composer2 = $composer2;
            return;
        }
        int i6 = $dirty2;
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new ModalBottomSheetKt$Scrim$2(color, onDismiss, visible, $changed));
    }

    /* access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$1(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(SwipeableV2State<?> state, Orientation orientation) {
        return new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(state, orientation);
    }

    /* access modifiers changed from: private */
    public static final AnchorChangeHandler<ModalBottomSheetValue> ModalBottomSheetAnchorChangeHandler(ModalBottomSheetState state, Function2<? super ModalBottomSheetValue, ? super Float, Unit> animateTo, Function1<? super ModalBottomSheetValue, Unit> snapTo) {
        return new ModalBottomSheetKt$ModalBottomSheetAnchorChangeHandler$1(state, animateTo, snapTo);
    }
}
