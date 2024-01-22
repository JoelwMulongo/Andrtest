package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a§\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b28\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aá\u0002\u0010 \u001a\u00020\u00042\u001c\u0010!\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001d2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020#2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010%¢\u0006\u0002\b\u001c2\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\b\u001c2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010%¢\u0006\u0002\b\u001c2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u00012 \b\u0002\u0010,\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001d2\b\b\u0002\u0010-\u001a\u00020\b2\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00012\b\b\u0002\u00100\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020\u00152\b\b\u0002\u00102\u001a\u00020\u00152\b\b\u0002\u00103\u001a\u00020\u00152\b\b\u0002\u00104\u001a\u00020\u00152\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a\\\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b092\u0006\u0010\u0005\u001a\u00020\u00062!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u00040\u001a2!\u0010<\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u00040\u001aH\u0002\u001aÈ\u0001\u0010=\u001a\u00020\u00042\u0013\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010%¢\u0006\u0002\b\u001c2&\u0010>\u001a\"\u0012\u0013\u0012\u001105¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\b\u001c2&\u0010@\u001a\"\u0012\u0013\u0012\u00110A¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\b\u001c2\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010%¢\u0006\u0002\b\u001c2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00040%¢\u0006\u0002\b\u001c2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00100%2\u0006\u0010D\u001a\u00020\u0006H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a4\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\u000e\b\u0002\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00100J2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u001aH\u0007\u001a\u001c\u0010L\u001a\u00020M2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030N2\u0006\u0010O\u001a\u00020PH\u0002\u001a+\u0010Q\u001a\u00020#2\b\b\u0002\u0010R\u001a\u00020S2\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020'H\u0007¢\u0006\u0002\u0010V\u001a;\u0010W\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\u000e\b\u0002\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00100J2\u0014\b\u0002\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u001aH\u0007¢\u0006\u0002\u0010X\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006Y"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheet", "", "state", "Landroidx/compose/material/BottomSheetState;", "sheetGesturesEnabled", "", "anchors", "Lkotlin/Function2;", "Landroidx/compose/material/BottomSheetValue;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/ui/unit/IntSize;", "sheetSize", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-0cLKjW4", "(Landroidx/compose/material/BottomSheetState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FJJLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffold", "sheetContent", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffoldAnchorChangeHandler", "Landroidx/compose/material/AnchorChangeHandler;", "animateTo", "target", "snapTo", "BottomSheetScaffoldLayout", "body", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "sheetState", "BottomSheetScaffoldLayout-KCBPh4w", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FILkotlin/jvm/functions/Function0;Landroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "BottomSheetScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/SwipeableV2State;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "rememberBottomSheetScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
public final class BottomSheetScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m5986constructorimpl((float) 16);

    public static /* synthetic */ BottomSheetState BottomSheetScaffoldState$default(BottomSheetValue bottomSheetValue, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        return BottomSheetScaffoldState(bottomSheetValue, animationSpec, function1);
    }

    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "BottomSheetScaffoldState(initialValue, animationSpec, confirmStateChange)", imports = {}))
    public static final BottomSheetState BottomSheetScaffoldState(BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        return new BottomSheetState(initialValue, animationSpec, confirmStateChange);
    }

    public static final BottomSheetState rememberBottomSheetState(BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(1808153344);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetState)P(2)202@7418L371:BottomSheetScaffold.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super BottomSheetValue, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 4) != 0) {
            confirmStateChange2 = BottomSheetScaffoldKt$rememberBottomSheetState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, $changed, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:197)");
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{animationSpec2}, BottomSheetState.Companion.Saver(animationSpec2, confirmStateChange2), (String) null, new BottomSheetScaffoldKt$rememberBottomSheetState$2(initialValue, animationSpec2, confirmStateChange2), $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetState;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(-1353009744);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetScaffoldState)P(1)240@8661L39,241@8743L35,242@8823L32,244@8897L248:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, $composer, 6, 2);
        }
        if ((i & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, (AnimationSpec<Float>) null, (Function1<? super BottomSheetValue, Boolean>) null, $composer, 6, 6);
        }
        if ((i & 4) != 0) {
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
            ComposerKt.traceEventStart(-1353009744, $changed, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:239)");
        }
        int i2 = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) drawerState) | $composer.changed((Object) bottomSheetState) | $composer.changed((Object) snackbarHostState);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    /* renamed from: BottomSheetScaffold-bGncdBI  reason: not valid java name */
    public static final void m1400BottomSheetScaffoldbGncdBI(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, Modifier modifier, BottomSheetScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> snackbarHost, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, int floatingActionButtonPosition, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, float sheetPeekHeight, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        Modifier modifier2;
        Function2 topBar2;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        long contentColor2;
        long backgroundColor2;
        long drawerScrimColor2;
        long drawerContentColor2;
        long drawerBackgroundColor2;
        float drawerElevation2;
        Shape drawerShape2;
        boolean drawerGesturesEnabled2;
        Function3 drawerContent2;
        float sheetPeekHeight2;
        long sheetContentColor2;
        long sheetBackgroundColor2;
        float sheetElevation2;
        Shape sheetShape2;
        boolean sheetGesturesEnabled2;
        int floatingActionButtonPosition2;
        Function2 floatingActionButton2;
        Function3 snackbarHost2;
        Function2 topBar3;
        BottomSheetScaffoldState scaffoldState2;
        Modifier modifier3;
        long contentColor3;
        long backgroundColor3;
        long drawerBackgroundColor3;
        long sheetBackgroundColor3;
        long drawerContentColor3;
        int $dirty2;
        long drawerScrimColor3;
        long sheetContentColor3;
        float drawerElevation3;
        boolean drawerGesturesEnabled3;
        Function3 drawerContent3;
        float sheetElevation3;
        Shape drawerShape3;
        int $dirty1;
        int $dirty;
        Shape sheetShape3;
        boolean sheetGesturesEnabled3;
        Function2 floatingActionButton3;
        float sheetPeekHeight3;
        int $dirty22;
        Function3 snackbarHost3;
        BottomSheetScaffoldState scaffoldState3;
        int i6;
        int $dirty23;
        int i7;
        int i8;
        BottomSheetScaffoldState scaffoldState4;
        Function2 topBar4;
        int floatingActionButtonPosition3;
        int $dirty3;
        long sheetBackgroundColor4;
        float sheetPeekHeight4;
        Shape drawerShape4;
        float drawerElevation4;
        float drawerElevation5;
        Shape drawerShape5;
        long drawerBackgroundColor4;
        float sheetPeekHeight5;
        long drawerScrimColor4;
        int i9;
        long drawerScrimColor5;
        int $dirty24;
        long backgroundColor4;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = sheetContent;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32 = content;
        int i20 = $changed;
        int i21 = $changed1;
        int i22 = $changed2;
        int i23 = i;
        Intrinsics.checkNotNullParameter(function3, "sheetContent");
        Intrinsics.checkNotNullParameter(function32, "content");
        Composer $composer2 = $composer.startRestartGroup(46422755);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffold)P(15,12,13,22,21,10,11:c#material.FabPosition,18,20,17:c#ui.unit.Dp,14:c#ui.graphics.Color,16:c#ui.graphics.Color,19:c#ui.unit.Dp,4,7,9,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)305@12585L34,311@12954L6,313@13085L6,314@13132L37,318@13389L6,320@13504L6,321@13552L38,322@13637L10,323@13692L6,324@13737L32,*327@13865L7,374@16050L713:BottomSheetScaffold.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty12 = $changed1;
        int $dirty25 = $changed2;
        if ((i23 & 1) != 0) {
            $dirty4 |= 6;
        } else if ((i20 & 14) == 0) {
            $dirty4 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i24 = i23 & 2;
        if (i24 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if ((i20 & 112) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i25 = 128;
        if ((i20 & 896) == 0) {
            if ((i23 & 4) != 0) {
                BottomSheetScaffoldState bottomSheetScaffoldState = scaffoldState;
            } else if ($composer2.changed((Object) scaffoldState)) {
                i19 = 256;
                $dirty4 |= i19;
            }
            i19 = 128;
            $dirty4 |= i19;
        } else {
            BottomSheetScaffoldState bottomSheetScaffoldState2 = scaffoldState;
        }
        int i26 = i23 & 8;
        int i27 = 2048;
        if (i26 != 0) {
            $dirty4 |= 3072;
            topBar2 = topBar;
        } else if ((i20 & 7168) == 0) {
            topBar2 = topBar;
            $dirty4 |= $composer2.changedInstance(topBar2) ? 2048 : 1024;
        } else {
            topBar2 = topBar;
        }
        int i28 = i23 & 16;
        int i29 = 16384;
        if (i28 != 0) {
            $dirty4 |= 24576;
            Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33 = snackbarHost;
        } else if ((i20 & 57344) == 0) {
            $dirty4 |= $composer2.changedInstance(snackbarHost) ? 16384 : 8192;
        } else {
            Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34 = snackbarHost;
        }
        int i30 = i23 & 32;
        if (i30 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function2<? super Composer, ? super Integer, Unit> function2 = floatingActionButton;
        } else if ((i20 & 458752) == 0) {
            $dirty4 |= $composer2.changedInstance(floatingActionButton) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = floatingActionButton;
        }
        int i31 = i23 & 64;
        if (i31 != 0) {
            $dirty4 |= 1572864;
            int i32 = floatingActionButtonPosition;
        } else if ((i20 & 3670016) == 0) {
            $dirty4 |= $composer2.changed(floatingActionButtonPosition) ? 1048576 : 524288;
        } else {
            int i33 = floatingActionButtonPosition;
        }
        int i34 = i23 & 128;
        if (i34 != 0) {
            $dirty4 |= 12582912;
            i2 = i34;
            boolean z = sheetGesturesEnabled;
        } else if ((i20 & 29360128) == 0) {
            i2 = i34;
            $dirty4 |= $composer2.changed(sheetGesturesEnabled) ? 8388608 : 4194304;
        } else {
            i2 = i34;
            boolean z2 = sheetGesturesEnabled;
        }
        if ((i20 & 234881024) == 0) {
            if ((i23 & 256) != 0) {
                Shape shape = sheetShape;
            } else if ($composer2.changed((Object) sheetShape)) {
                i18 = 67108864;
                $dirty4 |= i18;
            }
            i18 = 33554432;
            $dirty4 |= i18;
        } else {
            Shape shape2 = sheetShape;
        }
        int i35 = i23 & 512;
        if (i35 != 0) {
            $dirty4 |= 805306368;
            i3 = i35;
            float f = sheetElevation;
        } else if ((i20 & 1879048192) == 0) {
            i3 = i35;
            $dirty4 |= $composer2.changed(sheetElevation) ? 536870912 : 268435456;
        } else {
            i3 = i35;
            float f2 = sheetElevation;
        }
        if ((i21 & 14) == 0) {
            if ((i23 & 1024) != 0) {
                long j2 = sheetBackgroundColor;
            } else if ($composer2.changed(sheetBackgroundColor)) {
                i17 = 4;
                $dirty12 |= i17;
            }
            i17 = 2;
            $dirty12 |= i17;
        } else {
            long j3 = sheetBackgroundColor;
        }
        if ((i21 & 112) == 0) {
            if ((i23 & 2048) != 0) {
                long j4 = sheetContentColor;
            } else if ($composer2.changed(sheetContentColor)) {
                i16 = 32;
                $dirty12 |= i16;
            }
            i16 = 16;
            $dirty12 |= i16;
        } else {
            long j5 = sheetContentColor;
        }
        int i36 = i23 & 4096;
        if (i36 != 0) {
            $dirty12 |= 384;
            i4 = i36;
            float f3 = sheetPeekHeight;
        } else {
            i4 = i36;
            if ((i21 & 896) == 0) {
                $dirty12 |= $composer2.changed(sheetPeekHeight) ? 256 : 128;
            } else {
                float f4 = sheetPeekHeight;
            }
        }
        int i37 = i23 & 8192;
        if (i37 != 0) {
            $dirty12 |= 3072;
            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35 = drawerContent;
        } else if ((i21 & 7168) == 0) {
            if (!$composer2.changedInstance(drawerContent)) {
                i27 = 1024;
            }
            $dirty12 |= i27;
        } else {
            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function36 = drawerContent;
        }
        int i38 = i37;
        int i39 = i23 & 16384;
        if (i39 != 0) {
            $dirty12 |= 24576;
            i5 = i39;
            boolean z3 = drawerGesturesEnabled;
        } else if ((i21 & 57344) == 0) {
            i5 = i39;
            if (!$composer2.changed(drawerGesturesEnabled)) {
                i29 = 8192;
            }
            $dirty12 |= i29;
        } else {
            i5 = i39;
            boolean z4 = drawerGesturesEnabled;
        }
        if ((i21 & 458752) == 0) {
            if ((i23 & 32768) != 0) {
                Shape shape3 = drawerShape;
            } else if ($composer2.changed((Object) drawerShape)) {
                i15 = 131072;
                $dirty12 |= i15;
            }
            i15 = 65536;
            $dirty12 |= i15;
        } else {
            Shape shape4 = drawerShape;
        }
        int i40 = i23 & 65536;
        if (i40 != 0) {
            $dirty12 |= 1572864;
            float f5 = drawerElevation;
        } else if ((i21 & 3670016) == 0) {
            $dirty12 |= $composer2.changed(drawerElevation) ? 1048576 : 524288;
        } else {
            float f6 = drawerElevation;
        }
        if ((i21 & 29360128) == 0) {
            if ((i23 & 131072) != 0) {
                long j6 = drawerBackgroundColor;
            } else if ($composer2.changed(drawerBackgroundColor)) {
                i14 = 8388608;
                $dirty12 |= i14;
            }
            i14 = 4194304;
            $dirty12 |= i14;
        } else {
            long j7 = drawerBackgroundColor;
        }
        if ((i21 & 234881024) == 0) {
            if ((i23 & 262144) != 0) {
                long j8 = drawerContentColor;
            } else if ($composer2.changed(drawerContentColor)) {
                i13 = 67108864;
                $dirty12 |= i13;
            }
            i13 = 33554432;
            $dirty12 |= i13;
        } else {
            long j9 = drawerContentColor;
        }
        if ((i21 & 1879048192) == 0) {
            if ((i23 & 524288) != 0) {
                long j10 = drawerScrimColor;
            } else if ($composer2.changed(drawerScrimColor)) {
                i12 = 536870912;
                $dirty12 |= i12;
            }
            i12 = 268435456;
            $dirty12 |= i12;
        } else {
            long j11 = drawerScrimColor;
        }
        int $dirty13 = $dirty12;
        if ((i22 & 14) == 0) {
            if ((i23 & 1048576) != 0) {
                long j12 = backgroundColor;
            } else if ($composer2.changed(backgroundColor)) {
                i11 = 4;
                $dirty25 |= i11;
            }
            i11 = 2;
            $dirty25 |= i11;
        } else {
            long j13 = backgroundColor;
        }
        if ((i22 & 112) == 0) {
            if ((2097152 & i23) == 0) {
                j = contentColor;
                if ($composer2.changed(j)) {
                    i10 = 32;
                    $dirty25 |= i10;
                }
            } else {
                j = contentColor;
            }
            i10 = 16;
            $dirty25 |= i10;
        } else {
            j = contentColor;
        }
        if ((4194304 & i23) != 0) {
            $dirty25 |= 384;
        } else if ((i22 & 896) == 0) {
            if ($composer2.changedInstance(function32)) {
                i25 = 256;
            }
            $dirty25 |= i25;
        }
        if ((1533916891 & $dirty4) == 306783378 && ($dirty13 & 1533916891) == 306783378 && ($dirty25 & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            scaffoldState2 = scaffoldState;
            snackbarHost2 = snackbarHost;
            floatingActionButton2 = floatingActionButton;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            sheetGesturesEnabled2 = sheetGesturesEnabled;
            sheetShape2 = sheetShape;
            sheetElevation2 = sheetElevation;
            sheetBackgroundColor2 = sheetBackgroundColor;
            sheetContentColor2 = sheetContentColor;
            sheetPeekHeight2 = sheetPeekHeight;
            drawerContent2 = drawerContent;
            drawerGesturesEnabled2 = drawerGesturesEnabled;
            drawerShape2 = drawerShape;
            drawerElevation2 = drawerElevation;
            drawerBackgroundColor2 = drawerBackgroundColor;
            drawerContentColor2 = drawerContentColor;
            drawerScrimColor2 = drawerScrimColor;
            backgroundColor2 = backgroundColor;
            int i41 = $dirty4;
            int i42 = $dirty25;
            topBar3 = topBar2;
            contentColor2 = j;
            modifier3 = modifier2;
            int i43 = $dirty13;
        } else {
            $composer2.startDefaults();
            if ((i20 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i24 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i23 & 4) != 0) {
                    $dirty23 = $dirty25;
                    i6 = i4;
                    i8 = i2;
                    i7 = i3;
                    scaffoldState4 = rememberBottomSheetScaffoldState((DrawerState) null, (BottomSheetState) null, (SnackbarHostState) null, $composer2, 0, 7);
                    $dirty4 &= -897;
                } else {
                    $dirty23 = $dirty25;
                    i8 = i2;
                    i7 = i3;
                    i6 = i4;
                    scaffoldState4 = scaffoldState;
                }
                if (i26 != 0) {
                    topBar4 = null;
                } else {
                    topBar4 = topBar;
                }
                Function3 snackbarHost4 = i28 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1470getLambda1$material_release() : snackbarHost;
                if (i30 != 0) {
                    floatingActionButton3 = null;
                } else {
                    floatingActionButton3 = floatingActionButton;
                }
                if (i31 != 0) {
                    floatingActionButtonPosition3 = FabPosition.Companion.m1518getEnd5ygKITE();
                } else {
                    floatingActionButtonPosition3 = floatingActionButtonPosition;
                }
                if (i8 != 0) {
                    sheetGesturesEnabled3 = true;
                } else {
                    sheetGesturesEnabled3 = sheetGesturesEnabled;
                }
                BottomSheetScaffoldState scaffoldState5 = scaffoldState4;
                if ((i23 & 256) != 0) {
                    sheetShape3 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getLarge();
                    $dirty4 &= -234881025;
                } else {
                    sheetShape3 = sheetShape;
                }
                if (i7 != 0) {
                    sheetElevation3 = BottomSheetScaffoldDefaults.INSTANCE.m1397getSheetElevationD9Ej5fM();
                } else {
                    sheetElevation3 = sheetElevation;
                }
                if ((i23 & 1024) != 0) {
                    $dirty3 = $dirty4;
                    sheetBackgroundColor4 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1449getSurface0d7_KjU();
                    $dirty13 &= -15;
                } else {
                    $dirty3 = $dirty4;
                    sheetBackgroundColor4 = sheetBackgroundColor;
                }
                Function2 topBar5 = topBar4;
                if ((i23 & 2048) != 0) {
                    sheetContentColor3 = ColorsKt.m1463contentColorForek8zF_U(sheetBackgroundColor4, $composer2, $dirty13 & 14);
                    $dirty13 &= -113;
                } else {
                    sheetContentColor3 = sheetContentColor;
                }
                if (i6 != 0) {
                    sheetPeekHeight4 = BottomSheetScaffoldDefaults.INSTANCE.m1398getSheetPeekHeightD9Ej5fM();
                } else {
                    sheetPeekHeight4 = sheetPeekHeight;
                }
                if (i38 != 0) {
                    drawerContent3 = null;
                } else {
                    drawerContent3 = drawerContent;
                }
                if (i5 != 0) {
                    drawerGesturesEnabled3 = true;
                } else {
                    drawerGesturesEnabled3 = drawerGesturesEnabled;
                }
                if ((i23 & 32768) != 0) {
                    sheetBackgroundColor3 = sheetBackgroundColor4;
                    drawerShape4 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getLarge();
                    $dirty13 &= -458753;
                } else {
                    sheetBackgroundColor3 = sheetBackgroundColor4;
                    drawerShape4 = drawerShape;
                }
                if (i40 != 0) {
                    drawerElevation4 = DrawerDefaults.INSTANCE.m1485getElevationD9Ej5fM();
                } else {
                    drawerElevation4 = drawerElevation;
                }
                if ((i23 & 131072) != 0) {
                    drawerShape5 = drawerShape4;
                    drawerElevation5 = drawerElevation4;
                    drawerBackgroundColor4 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1449getSurface0d7_KjU();
                    $dirty13 &= -29360129;
                } else {
                    drawerShape5 = drawerShape4;
                    drawerElevation5 = drawerElevation4;
                    drawerBackgroundColor4 = drawerBackgroundColor;
                }
                if ((i23 & 262144) != 0) {
                    sheetPeekHeight5 = sheetPeekHeight4;
                    drawerContentColor3 = ColorsKt.m1463contentColorForek8zF_U(drawerBackgroundColor4, $composer2, ($dirty13 >> 21) & 14);
                    $dirty13 &= -234881025;
                } else {
                    sheetPeekHeight5 = sheetPeekHeight4;
                    drawerContentColor3 = drawerContentColor;
                }
                if ((i23 & 524288) != 0) {
                    drawerBackgroundColor3 = drawerBackgroundColor4;
                    i9 = 6;
                    drawerScrimColor4 = DrawerDefaults.INSTANCE.getScrimColor($composer2, 6);
                    $dirty13 &= -1879048193;
                } else {
                    drawerBackgroundColor3 = drawerBackgroundColor4;
                    i9 = 6;
                    drawerScrimColor4 = drawerScrimColor;
                }
                if ((i23 & 1048576) != 0) {
                    drawerScrimColor5 = drawerScrimColor4;
                    backgroundColor4 = MaterialTheme.INSTANCE.getColors($composer2, i9).m1438getBackground0d7_KjU();
                    $dirty24 = $dirty23 & -15;
                } else {
                    drawerScrimColor5 = drawerScrimColor4;
                    backgroundColor4 = backgroundColor;
                    $dirty24 = $dirty23;
                }
                if ((i23 & 2097152) != 0) {
                    Function3 snackbarHost5 = snackbarHost4;
                    long contentColor4 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor4, $composer2, $dirty24 & 14);
                    $dirty = $dirty3;
                    drawerShape3 = drawerShape5;
                    drawerElevation3 = drawerElevation5;
                    sheetPeekHeight3 = sheetPeekHeight5;
                    $dirty2 = $dirty24 & -113;
                    $dirty22 = floatingActionButtonPosition3;
                    $dirty1 = $dirty13;
                    contentColor3 = contentColor4;
                    drawerScrimColor3 = drawerScrimColor5;
                    topBar2 = topBar5;
                    backgroundColor3 = backgroundColor4;
                    scaffoldState3 = scaffoldState5;
                    snackbarHost3 = snackbarHost5;
                } else {
                    Function3 snackbarHost6 = snackbarHost4;
                    $dirty = $dirty3;
                    drawerShape3 = drawerShape5;
                    drawerElevation3 = drawerElevation5;
                    sheetPeekHeight3 = sheetPeekHeight5;
                    contentColor3 = contentColor;
                    backgroundColor3 = backgroundColor4;
                    $dirty2 = $dirty24;
                    $dirty22 = floatingActionButtonPosition3;
                    $dirty1 = $dirty13;
                    scaffoldState3 = scaffoldState5;
                    snackbarHost3 = snackbarHost6;
                    drawerScrimColor3 = drawerScrimColor5;
                    topBar2 = topBar5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i23 & 4) != 0) {
                    $dirty4 &= -897;
                }
                if ((i23 & 256) != 0) {
                    $dirty4 &= -234881025;
                }
                if ((i23 & 1024) != 0) {
                    $dirty13 &= -15;
                }
                if ((i23 & 2048) != 0) {
                    $dirty13 &= -113;
                }
                if ((32768 & i23) != 0) {
                    $dirty13 &= -458753;
                }
                if ((i23 & 131072) != 0) {
                    $dirty13 &= -29360129;
                }
                if ((262144 & i23) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((i23 & 524288) != 0) {
                    $dirty13 &= -1879048193;
                }
                if ((i23 & 1048576) != 0) {
                    $dirty25 &= -15;
                }
                if ((2097152 & i23) != 0) {
                    int i44 = $dirty25 & -113;
                    floatingActionButton3 = floatingActionButton;
                    $dirty22 = floatingActionButtonPosition;
                    sheetElevation3 = sheetElevation;
                    sheetBackgroundColor3 = sheetBackgroundColor;
                    sheetContentColor3 = sheetContentColor;
                    sheetPeekHeight3 = sheetPeekHeight;
                    drawerContent3 = drawerContent;
                    drawerGesturesEnabled3 = drawerGesturesEnabled;
                    drawerShape3 = drawerShape;
                    drawerElevation3 = drawerElevation;
                    drawerBackgroundColor3 = drawerBackgroundColor;
                    drawerContentColor3 = drawerContentColor;
                    backgroundColor3 = backgroundColor;
                    $dirty = $dirty4;
                    $dirty2 = i44;
                    contentColor3 = j;
                    $dirty1 = $dirty13;
                    scaffoldState3 = scaffoldState;
                    snackbarHost3 = snackbarHost;
                    sheetGesturesEnabled3 = sheetGesturesEnabled;
                    sheetShape3 = sheetShape;
                    drawerScrimColor3 = drawerScrimColor;
                } else {
                    snackbarHost3 = snackbarHost;
                    floatingActionButton3 = floatingActionButton;
                    sheetElevation3 = sheetElevation;
                    sheetBackgroundColor3 = sheetBackgroundColor;
                    sheetContentColor3 = sheetContentColor;
                    sheetPeekHeight3 = sheetPeekHeight;
                    drawerContent3 = drawerContent;
                    drawerGesturesEnabled3 = drawerGesturesEnabled;
                    drawerShape3 = drawerShape;
                    drawerElevation3 = drawerElevation;
                    drawerBackgroundColor3 = drawerBackgroundColor;
                    drawerContentColor3 = drawerContentColor;
                    backgroundColor3 = backgroundColor;
                    $dirty = $dirty4;
                    $dirty2 = $dirty25;
                    contentColor3 = j;
                    $dirty1 = $dirty13;
                    scaffoldState3 = scaffoldState;
                    $dirty22 = floatingActionButtonPosition;
                    sheetGesturesEnabled3 = sheetGesturesEnabled;
                    sheetShape3 = sheetShape;
                    drawerScrimColor3 = drawerScrimColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(46422755, $dirty, $dirty1, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:302)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function3 snackbarHost7 = snackbarHost3;
            int floatingActionButtonPosition4 = $dirty22;
            BottomSheetScaffoldState scaffoldState6 = scaffoldState3;
            SurfaceKt.m1620SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null), (Shape) null, backgroundColor3, contentColor3, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda($composer2, 1273816607, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(drawerContent3, ComposableLambdaKt.composableLambda($composer2, 893101063, true, new BottomSheetScaffoldKt$BottomSheetScaffold$child$1(scaffoldState3, topBar2, content, floatingActionButton3, sheetPeekHeight3, $dirty22, $dirty, $dirty2, $dirty1, sheetGesturesEnabled3, ((Density) consume).m5967toPx0680j_4(sheetPeekHeight3), sheetShape3, sheetElevation3, sheetBackgroundColor3, sheetContentColor3, sheetContent, snackbarHost3)), scaffoldState3, drawerGesturesEnabled3, drawerShape3, drawerElevation3, drawerBackgroundColor3, drawerContentColor3, drawerScrimColor3, $dirty1)), $composer2, (($dirty2 << 6) & 896) | 1572864 | (($dirty2 << 6) & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            snackbarHost2 = snackbarHost7;
            floatingActionButtonPosition2 = floatingActionButtonPosition4;
            sheetPeekHeight2 = sheetPeekHeight3;
            floatingActionButton2 = floatingActionButton3;
            topBar3 = topBar2;
            sheetGesturesEnabled2 = sheetGesturesEnabled3;
            sheetShape2 = sheetShape3;
            int i45 = $dirty;
            int i46 = $dirty1;
            drawerShape2 = drawerShape3;
            sheetElevation2 = sheetElevation3;
            drawerContent2 = drawerContent3;
            drawerGesturesEnabled2 = drawerGesturesEnabled3;
            drawerElevation2 = drawerElevation3;
            sheetContentColor2 = sheetContentColor3;
            drawerScrimColor2 = drawerScrimColor3;
            int i47 = $dirty2;
            drawerContentColor2 = drawerContentColor3;
            sheetBackgroundColor2 = sheetBackgroundColor3;
            drawerBackgroundColor2 = drawerBackgroundColor3;
            backgroundColor2 = backgroundColor3;
            contentColor2 = contentColor3;
            scaffoldState2 = scaffoldState6;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$2(sheetContent, modifier3, scaffoldState2, topBar3, snackbarHost2, floatingActionButton2, floatingActionButtonPosition2, sheetGesturesEnabled2, sheetShape2, sheetElevation2, sheetBackgroundColor2, sheetContentColor2, sheetPeekHeight2, drawerContent2, drawerGesturesEnabled2, drawerShape2, drawerElevation2, drawerBackgroundColor2, drawerContentColor2, drawerScrimColor2, backgroundColor2, contentColor2, content, $changed, $changed1, $changed2, i));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02b1  */
    /* renamed from: BottomSheet-0cLKjW4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1399BottomSheet0cLKjW4(androidx.compose.material.BottomSheetState r30, boolean r31, kotlin.jvm.functions.Function2<? super androidx.compose.material.BottomSheetValue, ? super androidx.compose.ui.unit.IntSize, java.lang.Float> r32, androidx.compose.ui.graphics.Shape r33, float r34, long r35, long r37, androidx.compose.ui.Modifier r39, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r14 = r30
            r15 = r32
            r13 = r40
            r12 = r42
            r11 = r43
            r0 = 2101692940(0x7d454a0c, float:1.6390149E37)
            r1 = r41
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BottomSheet)P(8,6!1,7,5:c#ui.unit.Dp,3:c#ui.graphics.Color,4:c#ui.graphics.Color,2)410@17189L24,411@17244L268,418@17517L1552:BottomSheetScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r42
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0021
            r1 = r1 | 6
            goto L_0x002f
        L_0x0021:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r10.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x002d
            r2 = 4
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r1 = r1 | r2
        L_0x002f:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0038
            r1 = r1 | 48
            r8 = r31
            goto L_0x004d
        L_0x0038:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004b
            r8 = r31
            boolean r2 = r10.changed((boolean) r8)
            if (r2 == 0) goto L_0x0047
            r2 = 32
            goto L_0x0049
        L_0x0047:
            r2 = 16
        L_0x0049:
            r1 = r1 | r2
            goto L_0x004d
        L_0x004b:
            r8 = r31
        L_0x004d:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x0054
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0054:
            r2 = r12 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0064
            boolean r2 = r10.changedInstance(r15)
            if (r2 == 0) goto L_0x0061
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r2
        L_0x0064:
            r2 = r11 & 8
            if (r2 == 0) goto L_0x006d
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r33
            goto L_0x0082
        L_0x006d:
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0080
            r9 = r33
            boolean r2 = r10.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x007c
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r1 = r1 | r2
            goto L_0x0082
        L_0x0080:
            r9 = r33
        L_0x0082:
            r2 = r11 & 16
            if (r2 == 0) goto L_0x008b
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r6 = r34
            goto L_0x00a2
        L_0x008b:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00a0
            r6 = r34
            boolean r2 = r10.changed((float) r6)
            if (r2 == 0) goto L_0x009c
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r1 = r1 | r2
            goto L_0x00a2
        L_0x00a0:
            r6 = r34
        L_0x00a2:
            r2 = r11 & 32
            r4 = 458752(0x70000, float:6.42848E-40)
            if (r2 == 0) goto L_0x00ae
            r2 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r2
            r4 = r35
            goto L_0x00c3
        L_0x00ae:
            r2 = r12 & r4
            if (r2 != 0) goto L_0x00c1
            r4 = r35
            boolean r2 = r10.changed((long) r4)
            if (r2 == 0) goto L_0x00bd
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r1 = r1 | r2
            goto L_0x00c3
        L_0x00c1:
            r4 = r35
        L_0x00c3:
            r2 = r11 & 64
            r7 = 1572864(0x180000, float:2.204052E-39)
            if (r2 == 0) goto L_0x00cd
            r1 = r1 | r7
            r7 = r37
            goto L_0x00e4
        L_0x00cd:
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00e2
            r7 = r37
            boolean r16 = r10.changed((long) r7)
            if (r16 == 0) goto L_0x00dd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r1 = r1 | r16
            goto L_0x00e4
        L_0x00e2:
            r7 = r37
        L_0x00e4:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ef
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r16
            r3 = r39
            goto L_0x0107
        L_0x00ef:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x0105
            r3 = r39
            boolean r16 = r10.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x0100
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0102
        L_0x0100:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x0102:
            r1 = r1 | r16
            goto L_0x0107
        L_0x0105:
            r3 = r39
        L_0x0107:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x010f
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x010d:
            r1 = r1 | r0
            goto L_0x0120
        L_0x010f:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r12
            if (r0 != 0) goto L_0x0120
            boolean r0 = r10.changedInstance(r13)
            if (r0 == 0) goto L_0x011d
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x011d:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x010d
        L_0x0120:
            r0 = 191739611(0xb6db6db, float:4.5782105E-32)
            r0 = r0 & r1
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r3) goto L_0x0137
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x0130
            goto L_0x0137
        L_0x0130:
            r10.skipToGroupEnd()
            r28 = r39
            goto L_0x02a6
        L_0x0137:
            if (r2 == 0) goto L_0x013e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0140
        L_0x013e:
            r0 = r39
        L_0x0140:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x014f
            r2 = -1
            java.lang.String r3 = "androidx.compose.material.BottomSheet (BottomSheetScaffold.kt:399)"
            r4 = 2101692940(0x7d454a0c, float:1.6390149E37)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x014f:
            r2 = 0
            r3 = r2
            r4 = 0
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            r5 = r10
            r16 = r2
            r17 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r2 = 0
            r18 = r10
            r19 = 0
            r20 = r2
            java.lang.Object r2 = r18.rememberedValue()
            r21 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r3
            java.lang.Object r3 = r22.getEmpty()
            if (r2 != r3) goto L_0x01a5
            r3 = 0
            r22 = 0
            kotlin.coroutines.EmptyCoroutineContext r22 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r26 = r2
            r2 = r22
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r5)
            r22 = r3
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r3.<init>(r2)
            r2 = r3
            r3 = r18
            r3.updateRememberedValue(r2)
            goto L_0x01a9
        L_0x01a5:
            r26 = r2
            r3 = r18
        L_0x01a9:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r3 = r2.getCoroutineScope()
            r10.endReplaceableGroup()
            r2 = r3
            r3 = r1 & 14
            r3 = r3 | 64
            r4 = 0
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            boolean r5 = r10.changed((java.lang.Object) r14)
            boolean r16 = r10.changed((java.lang.Object) r2)
            r5 = r5 | r16
            r16 = r10
            r17 = 0
            r18 = r3
            java.lang.Object r3 = r16.rememberedValue()
            r19 = 0
            if (r5 != 0) goto L_0x01f1
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r4
            java.lang.Object r4 = r20.getEmpty()
            if (r3 != r4) goto L_0x01ec
            goto L_0x01f3
        L_0x01ec:
            r20 = r3
            r4 = r16
            goto L_0x0212
        L_0x01f1:
            r21 = r4
        L_0x01f3:
            r4 = 0
            r20 = r3
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$anchorChangeHandler$1$1 r3 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$anchorChangeHandler$1$1
            r3.<init>(r2, r14)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r22 = r4
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$anchorChangeHandler$1$2 r4 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$anchorChangeHandler$1$2
            r4.<init>(r2, r14)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.material.AnchorChangeHandler r3 = BottomSheetScaffoldAnchorChangeHandler(r14, r3, r4)
            r4 = r16
            r4.updateRememberedValue(r3)
        L_0x0212:
            r10.endReplaceableGroup()
            androidx.compose.material.AnchorChangeHandler r3 = (androidx.compose.material.AnchorChangeHandler) r3
            androidx.compose.material.SwipeableV2State r17 = r30.getSwipeableState$material_release()
            androidx.compose.foundation.gestures.Orientation r18 = androidx.compose.foundation.gestures.Orientation.Vertical
            r20 = 0
            r21 = 0
            r22 = 24
            r23 = 0
            r16 = r0
            r19 = r31
            androidx.compose.ui.Modifier r4 = androidx.compose.material.SwipeableV2Kt.swipeableV2$default(r16, r17, r18, r19, r20, r21, r22, r23)
            androidx.compose.material.SwipeableV2State r5 = r30.getSwipeableState$material_release()
            r28 = r0
            r0 = 2
            androidx.compose.material.BottomSheetValue[] r0 = new androidx.compose.material.BottomSheetValue[r0]
            androidx.compose.material.BottomSheetValue r16 = androidx.compose.material.BottomSheetValue.Collapsed
            r17 = 0
            r0[r17] = r16
            androidx.compose.material.BottomSheetValue r16 = androidx.compose.material.BottomSheetValue.Expanded
            r6 = 1
            r0[r6] = r16
            java.util.Set r0 = kotlin.collections.SetsKt.setOf(r0)
            androidx.compose.ui.Modifier r0 = androidx.compose.material.SwipeableV2Kt.swipeAnchors(r4, r5, r0, r3, r15)
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1 r4 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1
            r4.<init>(r14, r2)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 0
            r29 = r2
            r2 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r2, r4, r6, r5)
            r22 = 0
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2 r0 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2
            r0.<init>(r13, r1)
            r2 = -1655326136(0xffffffff9d55ba48, float:-2.828662E-21)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r2, r6, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r2 = r1 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r4 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r4
            int r4 = r1 >> 9
            r4 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            int r4 = r1 >> 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r4
            int r4 = r1 << 3
            r5 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r5
            r26 = r2 | r4
            r27 = 16
            r17 = r33
            r18 = r35
            r20 = r37
            r23 = r34
            r24 = r0
            r25 = r10
            androidx.compose.material.SurfaceKt.m1620SurfaceFjzlyU(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02a6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a6:
            androidx.compose.runtime.ScopeUpdateScope r6 = r10.endRestartGroup()
            if (r6 != 0) goto L_0x02b1
            r17 = r1
            r18 = r10
            goto L_0x02db
        L_0x02b1:
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3 r16 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
            r0 = r16
            r17 = r1
            r1 = r30
            r2 = r31
            r3 = r32
            r4 = r33
            r5 = r34
            r8 = r6
            r6 = r35
            r14 = r8
            r8 = r37
            r18 = r10
            r10 = r28
            r11 = r40
            r12 = r42
            r13 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x02db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1399BottomSheet0cLKjW4(androidx.compose.material.BottomSheetState, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, float, long, long, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-KCBPh4w  reason: not valid java name */
    public static final void m1401BottomSheetScaffoldLayoutKCBPh4w(Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> body, Function3<? super Integer, ? super Composer, ? super Integer, Unit> bottomSheet, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, Function2<? super Composer, ? super Integer, Unit> snackbarHost, float sheetPeekHeight, int floatingActionButtonPosition, Function0<Float> sheetOffset, BottomSheetState sheetState, Composer $composer, int $changed) {
        int i;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(1621720523);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,3:c#material.FabPosition)487@19983L2466,487@19966L2483:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if ((i2 & 14) == 0) {
            $dirty |= $composer2.changedInstance(topBar) ? 4 : 2;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = topBar;
        }
        if ((i2 & 112) == 0) {
            $dirty |= $composer2.changedInstance(body) ? 32 : 16;
        } else {
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3 = body;
        }
        if ((i2 & 896) == 0) {
            $dirty |= $composer2.changedInstance(bottomSheet) ? 256 : 128;
        } else {
            Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32 = bottomSheet;
        }
        if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(floatingActionButton) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = floatingActionButton;
        }
        if ((57344 & i2) == 0) {
            $dirty |= $composer2.changedInstance(snackbarHost) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = snackbarHost;
        }
        if ((458752 & i2) == 0) {
            $dirty |= $composer2.changed(sheetPeekHeight) ? 131072 : 65536;
        } else {
            float f = sheetPeekHeight;
        }
        if ((3670016 & i2) == 0) {
            $dirty |= $composer2.changed(floatingActionButtonPosition) ? 1048576 : 524288;
        } else {
            int i3 = floatingActionButtonPosition;
        }
        if ((29360128 & i2) == 0) {
            $dirty |= $composer2.changedInstance(sheetOffset) ? 8388608 : 4194304;
        } else {
            Function0<Float> function0 = sheetOffset;
        }
        if ((234881024 & i2) == 0) {
            $dirty |= $composer2.changed((Object) sheetState) ? 67108864 : 33554432;
        } else {
            BottomSheetState bottomSheetState = sheetState;
        }
        if ((191739611 & $dirty) != 38347922 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1621720523, $dirty, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:476)");
            }
            Object[] keys$iv = {bottomSheet, sheetOffset, topBar, body, Dp.m5984boximpl(sheetPeekHeight), floatingActionButton, FabPosition.m1510boximpl(floatingActionButtonPosition), snackbarHost, sheetState};
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
                value$iv$iv = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(sheetOffset, topBar, floatingActionButton, floatingActionButtonPosition, sheetPeekHeight, snackbarHost, sheetState, bottomSheet, $dirty, body);
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
        endRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(topBar, body, bottomSheet, floatingActionButton, snackbarHost, sheetPeekHeight, floatingActionButtonPosition, sheetOffset, sheetState, $changed));
    }

    /* access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(SwipeableV2State<?> state, Orientation orientation) {
        return new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(state, orientation);
    }

    /* access modifiers changed from: private */
    public static final AnchorChangeHandler<BottomSheetValue> BottomSheetScaffoldAnchorChangeHandler(BottomSheetState state, Function1<? super BottomSheetValue, Unit> animateTo, Function1<? super BottomSheetValue, Unit> snapTo) {
        return new BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1(state, animateTo, snapTo);
    }
}
