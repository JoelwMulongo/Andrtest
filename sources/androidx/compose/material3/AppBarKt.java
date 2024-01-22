package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ao\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0010(\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u00100\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u00101\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u0001\u00102\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0003¢\u0006\u0002\u00107\u001a\u00108\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u00109\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a¦\u0001\u0010:\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u001c2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u0002062\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a¸\u0001\u0010J\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u00020\u00012\u0011\u0010K\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010L\u001a\u0002042\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a+\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020<2\b\b\u0002\u0010T\u001a\u00020<2\b\b\u0002\u0010U\u001a\u00020<H\u0007¢\u0006\u0002\u0010V\u001aD\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020R2\u0006\u0010Z\u001a\u00020<2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\\2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010^H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010_\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "MediumTopAppBar", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SmallTopAppBar", "TopAppBar", "TopAppBarLayout", "heightPx", "", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "maxHeight", "pinnedHeight", "TwoRowsTopAppBar-tjU4iQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;FFLandroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "initialHeightOffsetLimit", "initialHeightOffset", "initialContentOffset", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppBar.kt */
public final class AppBarKt {
    /* access modifiers changed from: private */
    public static final float BottomAppBarHorizontalPadding = Dp.m5986constructorimpl(Dp.m5986constructorimpl((float) 16) - Dp.m5986constructorimpl((float) 12));
    private static final float BottomAppBarVerticalPadding = Dp.m5986constructorimpl(Dp.m5986constructorimpl((float) 16) - Dp.m5986constructorimpl((float) 12));
    /* access modifiers changed from: private */
    public static final float FABHorizontalPadding = Dp.m5986constructorimpl(Dp.m5986constructorimpl((float) 16) - BottomAppBarHorizontalPadding);
    /* access modifiers changed from: private */
    public static final float FABVerticalPadding = Dp.m5986constructorimpl(Dp.m5986constructorimpl((float) 12) - BottomAppBarVerticalPadding);
    private static final float LargeTitleBottomPadding = Dp.m5986constructorimpl((float) 28);
    private static final float MediumTitleBottomPadding = Dp.m5986constructorimpl((float) 24);
    private static final float TopAppBarHorizontalPadding = Dp.m5986constructorimpl((float) 4);
    /* access modifiers changed from: private */
    public static final float TopAppBarTitleInset = Dp.m5986constructorimpl(Dp.m5986constructorimpl((float) 16) - TopAppBarHorizontalPadding);
    private static final CubicBezierEasing TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.foundation.layout.WindowInsets r34, androidx.compose.material3.TopAppBarColors r35, androidx.compose.material3.TopAppBarScrollBehavior r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r12 = r30
            r13 = r38
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1906353009(0x71a0a371, float:1.5908861E30)
            r1 = r37
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TopAppBar)P(5,2,3!1,6)125@6260L12,126@6322L22,132@6517L10,129@6406L374:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r38
            r2 = r39 & 1
            if (r2 == 0) goto L_0x0021
            r1 = r1 | 6
            goto L_0x002f
        L_0x0021:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r11.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x002d
            r2 = 4
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r1 = r1 | r2
        L_0x002f:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x0038
            r1 = r1 | 48
            r3 = r31
            goto L_0x004d
        L_0x0038:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            r3 = r31
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0047
            r4 = 32
            goto L_0x0049
        L_0x0047:
            r4 = 16
        L_0x0049:
            r1 = r1 | r4
            goto L_0x004d
        L_0x004b:
            r3 = r31
        L_0x004d:
            r4 = r39 & 4
            if (r4 == 0) goto L_0x0056
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r32
            goto L_0x006b
        L_0x0056:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r32
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0065
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r6
            goto L_0x006b
        L_0x0069:
            r5 = r32
        L_0x006b:
            r6 = r39 & 8
            if (r6 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r33
            goto L_0x0089
        L_0x0074:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0087
            r7 = r33
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0083
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r8
            goto L_0x0089
        L_0x0087:
            r7 = r33
        L_0x0089:
            r8 = 57344(0xe000, float:8.0356E-41)
            r9 = r13 & r8
            if (r9 != 0) goto L_0x00a5
            r9 = r39 & 16
            if (r9 != 0) goto L_0x009f
            r9 = r34
            boolean r10 = r11.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00a1
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r9 = r34
        L_0x00a1:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r10
            goto L_0x00a7
        L_0x00a5:
            r9 = r34
        L_0x00a7:
            r10 = 458752(0x70000, float:6.42848E-40)
            r14 = r13 & r10
            if (r14 != 0) goto L_0x00c2
            r14 = r39 & 32
            if (r14 != 0) goto L_0x00bc
            r15 = r35
            boolean r14 = r11.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00be
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00bc:
            r15 = r35
        L_0x00be:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r1 = r1 | r14
            goto L_0x00c4
        L_0x00c2:
            r15 = r35
        L_0x00c4:
            r28 = r39 & 64
            r29 = 3670016(0x380000, float:5.142788E-39)
            if (r28 == 0) goto L_0x00d0
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            r14 = r36
            goto L_0x00e6
        L_0x00d0:
            r14 = r13 & r29
            if (r14 != 0) goto L_0x00e4
            r14 = r36
            boolean r16 = r11.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x00df
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r1 = r1 | r16
            goto L_0x00e6
        L_0x00e4:
            r14 = r36
        L_0x00e6:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r1 & r16
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r8) goto L_0x010a
            boolean r8 = r11.getSkipping()
            if (r8 != 0) goto L_0x00f7
            goto L_0x010a
        L_0x00f7:
            r11.skipToGroupEnd()
            r22 = r1
            r16 = r7
            r17 = r9
            r20 = r11
            r19 = r14
            r18 = r15
            r14 = r3
            r15 = r5
            goto L_0x0212
        L_0x010a:
            r11.startDefaults()
            r8 = r13 & 1
            r10 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = 6
            if (r8 == 0) goto L_0x013a
            boolean r8 = r11.getDefaultsInvalid()
            if (r8 == 0) goto L_0x011f
            goto L_0x013a
        L_0x011f:
            r11.skipToGroupEnd()
            r2 = r39 & 16
            if (r2 == 0) goto L_0x0128
            r1 = r1 & r16
        L_0x0128:
            r2 = r39 & 32
            if (r2 == 0) goto L_0x012d
            r1 = r1 & r10
        L_0x012d:
            r10 = r1
            r16 = r7
            r17 = r9
            r19 = r14
            r18 = r15
            r14 = r3
            r15 = r5
            goto L_0x019c
        L_0x013a:
            if (r2 == 0) goto L_0x0141
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0142
        L_0x0141:
            r2 = r3
        L_0x0142:
            if (r4 == 0) goto L_0x014b
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1860getLambda1$material3_release()
            goto L_0x014c
        L_0x014b:
            r3 = r5
        L_0x014c:
            if (r6 == 0) goto L_0x0155
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1864getLambda2$material3_release()
            r7 = r4
        L_0x0155:
            r4 = r39 & 16
            if (r4 == 0) goto L_0x0162
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r11, r0)
            r1 = r1 & r16
            r9 = r4
        L_0x0162:
            r4 = r39 & 32
            if (r4 == 0) goto L_0x0180
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r5 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 31
            r14 = r4
            r15 = r5
            r25 = r11
            androidx.compose.material3.TopAppBarColors r4 = r14.m2251smallTopAppBarColorszjMxDiM(r15, r17, r19, r21, r23, r25, r26, r27)
            r1 = r1 & r10
            goto L_0x0182
        L_0x0180:
            r4 = r35
        L_0x0182:
            if (r28 == 0) goto L_0x0191
            r5 = 0
            r10 = r1
            r14 = r2
            r15 = r3
            r18 = r4
            r19 = r5
            r16 = r7
            r17 = r9
            goto L_0x019c
        L_0x0191:
            r19 = r36
            r10 = r1
            r14 = r2
            r15 = r3
            r18 = r4
            r16 = r7
            r17 = r9
        L_0x019c:
            r11.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ae
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.TopAppBar (AppBar.kt:120)"
            r3 = 1906353009(0x71a0a371, float:1.5908861E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r10, r1, r2)
        L_0x01ae:
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r0 = r1.getTypography(r11, r0)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r1 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r1 = r1.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.material3.TypographyKt.fromToken(r0, r1)
            r3 = 0
            int r0 = r10 >> 3
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r10 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r10 << 6
            r4 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r10 << 6
            r4 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r10 << 6
            r1 = r1 & r29
            r0 = r0 | r1
            int r1 = r10 << 6
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r10 << 6
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r4
            r20 = r0 | r1
            r21 = 0
            r0 = r14
            r1 = r30
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r11
            r22 = r10
            r10 = r20
            r20 = r11
            r11 = r21
            SingleRowTopAppBar(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0212
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0212:
            androidx.compose.runtime.ScopeUpdateScope r10 = r20.endRestartGroup()
            if (r10 != 0) goto L_0x0219
            goto L_0x0234
        L_0x0219:
            androidx.compose.material3.AppBarKt$TopAppBar$1 r11 = new androidx.compose.material3.AppBarKt$TopAppBar$1
            r0 = r11
            r1 = r30
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r38
            r9 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0234:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.TopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use TopAppBar instead.", replaceWith = @kotlin.ReplaceWith(expression = "TopAppBar(title, modifier, navigationIcon, actions, windowInsets, colors, scrollBehavior)", imports = {}))
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SmallTopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.foundation.layout.WindowInsets r34, androidx.compose.material3.TopAppBarColors r35, androidx.compose.material3.TopAppBarScrollBehavior r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r10 = r30
            r11 = r38
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1967617284(0xffffffff8ab88afc, float:-1.7770836E-32)
            r1 = r37
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SmallTopAppBar)P(5,2,3!1,6)188@9249L12,189@9311L22,191@9391L89:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r38
            r2 = r39 & 1
            if (r2 == 0) goto L_0x0021
            r1 = r1 | 6
            goto L_0x002f
        L_0x0021:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r9.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x002d
            r2 = 4
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r1 = r1 | r2
        L_0x002f:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x0038
            r1 = r1 | 48
            r3 = r31
            goto L_0x004d
        L_0x0038:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            r3 = r31
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0047
            r4 = 32
            goto L_0x0049
        L_0x0047:
            r4 = 16
        L_0x0049:
            r1 = r1 | r4
            goto L_0x004d
        L_0x004b:
            r3 = r31
        L_0x004d:
            r4 = r39 & 4
            if (r4 == 0) goto L_0x0056
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r32
            goto L_0x006b
        L_0x0056:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r32
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0065
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r6
            goto L_0x006b
        L_0x0069:
            r5 = r32
        L_0x006b:
            r6 = r39 & 8
            if (r6 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r33
            goto L_0x0089
        L_0x0074:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0087
            r7 = r33
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0083
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r8
            goto L_0x0089
        L_0x0087:
            r7 = r33
        L_0x0089:
            r8 = 57344(0xe000, float:8.0356E-41)
            r12 = r11 & r8
            if (r12 != 0) goto L_0x00a5
            r12 = r39 & 16
            if (r12 != 0) goto L_0x009f
            r12 = r34
            boolean r13 = r9.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00a1
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r12 = r34
        L_0x00a1:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r13
            goto L_0x00a7
        L_0x00a5:
            r12 = r34
        L_0x00a7:
            r26 = 458752(0x70000, float:6.42848E-40)
            r13 = r11 & r26
            if (r13 != 0) goto L_0x00c2
            r13 = r39 & 32
            if (r13 != 0) goto L_0x00bc
            r15 = r35
            boolean r13 = r9.changed((java.lang.Object) r15)
            if (r13 == 0) goto L_0x00be
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00bc:
            r15 = r35
        L_0x00be:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r1 = r1 | r13
            goto L_0x00c4
        L_0x00c2:
            r15 = r35
        L_0x00c4:
            r27 = r39 & 64
            r28 = 3670016(0x380000, float:5.142788E-39)
            if (r27 == 0) goto L_0x00d0
            r13 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r13
            r13 = r36
            goto L_0x00e5
        L_0x00d0:
            r13 = r11 & r28
            if (r13 != 0) goto L_0x00e3
            r13 = r36
            boolean r14 = r9.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00df
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r1 = r1 | r14
            goto L_0x00e5
        L_0x00e3:
            r13 = r36
        L_0x00e5:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r1
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r8) goto L_0x0106
            boolean r8 = r9.getSkipping()
            if (r8 != 0) goto L_0x00f5
            goto L_0x0106
        L_0x00f5:
            r9.skipToGroupEnd()
            r20 = r1
            r14 = r7
            r18 = r9
            r17 = r13
            r16 = r15
            r13 = r5
            r15 = r12
            r12 = r3
            goto L_0x01e1
        L_0x0106:
            r9.startDefaults()
            r8 = r11 & 1
            r29 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            if (r8 == 0) goto L_0x0133
            boolean r8 = r9.getDefaultsInvalid()
            if (r8 == 0) goto L_0x011a
            goto L_0x0133
        L_0x011a:
            r9.skipToGroupEnd()
            r2 = r39 & 16
            if (r2 == 0) goto L_0x0122
            r1 = r1 & r14
        L_0x0122:
            r2 = r39 & 32
            if (r2 == 0) goto L_0x0128
            r1 = r1 & r29
        L_0x0128:
            r8 = r1
            r14 = r7
            r17 = r13
            r16 = r15
            r13 = r5
            r15 = r12
            r12 = r3
            goto L_0x019a
        L_0x0133:
            if (r2 == 0) goto L_0x013a
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x013b
        L_0x013a:
            r2 = r3
        L_0x013b:
            if (r4 == 0) goto L_0x0144
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1865getLambda3$material3_release()
            goto L_0x0145
        L_0x0144:
            r3 = r5
        L_0x0145:
            if (r6 == 0) goto L_0x014e
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1866getLambda4$material3_release()
            r7 = r4
        L_0x014e:
            r4 = r39 & 16
            if (r4 == 0) goto L_0x015b
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r5 = 6
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r9, r5)
            r1 = r1 & r14
            goto L_0x015c
        L_0x015b:
            r4 = r12
        L_0x015c:
            r5 = r39 & 32
            if (r5 == 0) goto L_0x0182
            androidx.compose.material3.TopAppBarDefaults r12 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r5 = 0
            r16 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r24 = 196608(0x30000, float:2.75506E-40)
            r25 = 31
            r13 = r5
            r15 = r16
            r17 = r18
            r19 = r20
            r21 = r22
            r23 = r9
            androidx.compose.material3.TopAppBarColors r5 = r12.m2251smallTopAppBarColorszjMxDiM(r13, r15, r17, r19, r21, r23, r24, r25)
            r1 = r1 & r29
            goto L_0x0184
        L_0x0182:
            r5 = r35
        L_0x0184:
            if (r27 == 0) goto L_0x0191
            r6 = 0
            r8 = r1
            r12 = r2
            r13 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r14 = r7
            goto L_0x019a
        L_0x0191:
            r17 = r36
            r8 = r1
            r12 = r2
            r13 = r3
            r15 = r4
            r16 = r5
            r14 = r7
        L_0x019a:
            r9.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01a9
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.SmallTopAppBar (AppBar.kt:183)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r1, r2)
        L_0x01a9:
            r0 = r8 & 14
            r1 = r8 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r8 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r8 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r8
            r0 = r0 | r1
            r1 = r8 & r26
            r0 = r0 | r1
            r1 = r8 & r28
            r18 = r0 | r1
            r19 = 0
            r0 = r30
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r9
            r20 = r8
            r8 = r18
            r18 = r9
            r9 = r19
            TopAppBar(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01e1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e1:
            androidx.compose.runtime.ScopeUpdateScope r9 = r18.endRestartGroup()
            if (r9 != 0) goto L_0x01e8
            goto L_0x0205
        L_0x01e8:
            androidx.compose.material3.AppBarKt$SmallTopAppBar$1 r19 = new androidx.compose.material3.AppBarKt$SmallTopAppBar$1
            r0 = r19
            r1 = r30
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r38
            r10 = r9
            r9 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0205:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SmallTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CenterAlignedTopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.foundation.layout.WindowInsets r34, androidx.compose.material3.TopAppBarColors r35, androidx.compose.material3.TopAppBarScrollBehavior r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r12 = r30
            r13 = r38
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -2139286460(0xffffffff807d1444, float:-1.1486707E-38)
            r1 = r37
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CenterAlignedTopAppBar)P(5,2,3!1,6)229@11673L12,230@11735L30,237@11946L10,233@11827L381:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r38
            r2 = r39 & 1
            if (r2 == 0) goto L_0x0021
            r1 = r1 | 6
            goto L_0x002f
        L_0x0021:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r11.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x002d
            r2 = 4
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r1 = r1 | r2
        L_0x002f:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x0038
            r1 = r1 | 48
            r3 = r31
            goto L_0x004d
        L_0x0038:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            r3 = r31
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0047
            r4 = 32
            goto L_0x0049
        L_0x0047:
            r4 = 16
        L_0x0049:
            r1 = r1 | r4
            goto L_0x004d
        L_0x004b:
            r3 = r31
        L_0x004d:
            r4 = r39 & 4
            if (r4 == 0) goto L_0x0056
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r32
            goto L_0x006b
        L_0x0056:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r32
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0065
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r6
            goto L_0x006b
        L_0x0069:
            r5 = r32
        L_0x006b:
            r6 = r39 & 8
            if (r6 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r33
            goto L_0x0089
        L_0x0074:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0087
            r7 = r33
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0083
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r8
            goto L_0x0089
        L_0x0087:
            r7 = r33
        L_0x0089:
            r8 = 57344(0xe000, float:8.0356E-41)
            r9 = r13 & r8
            if (r9 != 0) goto L_0x00a5
            r9 = r39 & 16
            if (r9 != 0) goto L_0x009f
            r9 = r34
            boolean r10 = r11.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00a1
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r9 = r34
        L_0x00a1:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r10
            goto L_0x00a7
        L_0x00a5:
            r9 = r34
        L_0x00a7:
            r10 = 458752(0x70000, float:6.42848E-40)
            r14 = r13 & r10
            if (r14 != 0) goto L_0x00c2
            r14 = r39 & 32
            if (r14 != 0) goto L_0x00bc
            r15 = r35
            boolean r14 = r11.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00be
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00bc:
            r15 = r35
        L_0x00be:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r1 = r1 | r14
            goto L_0x00c4
        L_0x00c2:
            r15 = r35
        L_0x00c4:
            r28 = r39 & 64
            r29 = 3670016(0x380000, float:5.142788E-39)
            if (r28 == 0) goto L_0x00d0
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            r14 = r36
            goto L_0x00e6
        L_0x00d0:
            r14 = r13 & r29
            if (r14 != 0) goto L_0x00e4
            r14 = r36
            boolean r16 = r11.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x00df
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r1 = r1 | r16
            goto L_0x00e6
        L_0x00e4:
            r14 = r36
        L_0x00e6:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r1 & r16
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r8) goto L_0x010a
            boolean r8 = r11.getSkipping()
            if (r8 != 0) goto L_0x00f7
            goto L_0x010a
        L_0x00f7:
            r11.skipToGroupEnd()
            r22 = r1
            r16 = r7
            r17 = r9
            r20 = r11
            r19 = r14
            r18 = r15
            r14 = r3
            r15 = r5
            goto L_0x0213
        L_0x010a:
            r11.startDefaults()
            r8 = r13 & 1
            r10 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = 6
            if (r8 == 0) goto L_0x013a
            boolean r8 = r11.getDefaultsInvalid()
            if (r8 == 0) goto L_0x011f
            goto L_0x013a
        L_0x011f:
            r11.skipToGroupEnd()
            r2 = r39 & 16
            if (r2 == 0) goto L_0x0128
            r1 = r1 & r16
        L_0x0128:
            r2 = r39 & 32
            if (r2 == 0) goto L_0x012d
            r1 = r1 & r10
        L_0x012d:
            r10 = r1
            r16 = r7
            r17 = r9
            r19 = r14
            r18 = r15
            r14 = r3
            r15 = r5
            goto L_0x019c
        L_0x013a:
            if (r2 == 0) goto L_0x0141
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0142
        L_0x0141:
            r2 = r3
        L_0x0142:
            if (r4 == 0) goto L_0x014b
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1867getLambda5$material3_release()
            goto L_0x014c
        L_0x014b:
            r3 = r5
        L_0x014c:
            if (r6 == 0) goto L_0x0155
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1868getLambda6$material3_release()
            r7 = r4
        L_0x0155:
            r4 = r39 & 16
            if (r4 == 0) goto L_0x0162
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r11, r0)
            r1 = r1 & r16
            r9 = r4
        L_0x0162:
            r4 = r39 & 32
            if (r4 == 0) goto L_0x0180
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r5 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 31
            r14 = r4
            r15 = r5
            r25 = r11
            androidx.compose.material3.TopAppBarColors r4 = r14.m2248centerAlignedTopAppBarColorszjMxDiM(r15, r17, r19, r21, r23, r25, r26, r27)
            r1 = r1 & r10
            goto L_0x0182
        L_0x0180:
            r4 = r35
        L_0x0182:
            if (r28 == 0) goto L_0x0191
            r5 = 0
            r10 = r1
            r14 = r2
            r15 = r3
            r18 = r4
            r19 = r5
            r16 = r7
            r17 = r9
            goto L_0x019c
        L_0x0191:
            r19 = r36
            r10 = r1
            r14 = r2
            r15 = r3
            r18 = r4
            r16 = r7
            r17 = r9
        L_0x019c:
            r11.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ae
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:224)"
            r3 = -2139286460(0xffffffff807d1444, float:-1.1486707E-38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r10, r1, r2)
        L_0x01ae:
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r0 = r1.getTypography(r11, r0)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r1 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r1 = r1.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.material3.TypographyKt.fromToken(r0, r1)
            r3 = 1
            int r0 = r10 >> 3
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r10 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r10 << 6
            r4 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r10 << 6
            r4 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r10 << 6
            r1 = r1 & r29
            r0 = r0 | r1
            int r1 = r10 << 6
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r10 << 6
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r4
            r20 = r0 | r1
            r21 = 0
            r0 = r14
            r1 = r30
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r11
            r22 = r10
            r10 = r20
            r20 = r11
            r11 = r21
            SingleRowTopAppBar(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0213
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0213:
            androidx.compose.runtime.ScopeUpdateScope r10 = r20.endRestartGroup()
            if (r10 != 0) goto L_0x021a
            goto L_0x0235
        L_0x021a:
            androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1 r11 = new androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1
            r0 = r11
            r1 = r30
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r38
            r9 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0235:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MediumTopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.ui.Modifier r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.foundation.layout.WindowInsets r35, androidx.compose.material3.TopAppBarColors r36, androidx.compose.material3.TopAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r13 = r31
            r12 = r39
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 1805417862(0x6b9c7d86, float:3.783704E26)
            r1 = r38
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(MediumTopAppBar)P(5,2,3!1,6)284@14526L12,285@14588L23,291@14782L10,292@14884L10,288@14673L646:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r39
            r2 = r40 & 1
            if (r2 == 0) goto L_0x0021
            r1 = r1 | 6
            goto L_0x002f
        L_0x0021:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r9.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x002d
            r2 = 4
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r1 = r1 | r2
        L_0x002f:
            r2 = r40 & 2
            if (r2 == 0) goto L_0x0038
            r1 = r1 | 48
            r3 = r32
            goto L_0x004d
        L_0x0038:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            r3 = r32
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0047
            r4 = 32
            goto L_0x0049
        L_0x0047:
            r4 = 16
        L_0x0049:
            r1 = r1 | r4
            goto L_0x004d
        L_0x004b:
            r3 = r32
        L_0x004d:
            r4 = r40 & 4
            if (r4 == 0) goto L_0x0056
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r33
            goto L_0x006b
        L_0x0056:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r33
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0065
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r6
            goto L_0x006b
        L_0x0069:
            r5 = r33
        L_0x006b:
            r6 = r40 & 8
            if (r6 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r34
            goto L_0x0089
        L_0x0074:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0087
            r7 = r34
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0083
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r8
            goto L_0x0089
        L_0x0087:
            r7 = r34
        L_0x0089:
            r8 = 57344(0xe000, float:8.0356E-41)
            r10 = r12 & r8
            if (r10 != 0) goto L_0x00a5
            r10 = r40 & 16
            if (r10 != 0) goto L_0x009f
            r10 = r35
            boolean r11 = r9.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x00a1
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r10 = r35
        L_0x00a1:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r11
            goto L_0x00a7
        L_0x00a5:
            r10 = r35
        L_0x00a7:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r12
            if (r11 != 0) goto L_0x00c1
            r11 = r40 & 32
            if (r11 != 0) goto L_0x00bb
            r11 = r36
            boolean r14 = r9.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x00bd
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bb:
            r11 = r36
        L_0x00bd:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r1 = r1 | r14
            goto L_0x00c3
        L_0x00c1:
            r11 = r36
        L_0x00c3:
            r28 = r40 & 64
            r29 = 3670016(0x380000, float:5.142788E-39)
            if (r28 == 0) goto L_0x00cf
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            r15 = r37
            goto L_0x00e4
        L_0x00cf:
            r14 = r12 & r29
            if (r14 != 0) goto L_0x00e2
            r15 = r37
            boolean r14 = r9.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00de
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r1 = r1 | r14
            goto L_0x00e4
        L_0x00e2:
            r15 = r37
        L_0x00e4:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r1
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r8) goto L_0x0105
            boolean r8 = r9.getSkipping()
            if (r8 != 0) goto L_0x00f4
            goto L_0x0105
        L_0x00f4:
            r9.skipToGroupEnd()
            r23 = r1
            r17 = r3
            r18 = r5
            r19 = r7
            r24 = r9
            r22 = r15
            goto L_0x023e
        L_0x0105:
            r9.startDefaults()
            r8 = r12 & 1
            r30 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = 6
            if (r8 == 0) goto L_0x0137
            boolean r8 = r9.getDefaultsInvalid()
            if (r8 == 0) goto L_0x011a
            goto L_0x0137
        L_0x011a:
            r9.skipToGroupEnd()
            r2 = r40 & 16
            if (r2 == 0) goto L_0x0122
            r1 = r1 & r14
        L_0x0122:
            r2 = r40 & 32
            if (r2 == 0) goto L_0x0128
            r1 = r1 & r30
        L_0x0128:
            r8 = r1
            r17 = r3
            r18 = r5
            r19 = r7
            r20 = r10
            r21 = r11
            r22 = r15
            goto L_0x019a
        L_0x0137:
            if (r2 == 0) goto L_0x013e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x013f
        L_0x013e:
            r2 = r3
        L_0x013f:
            if (r4 == 0) goto L_0x0148
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1869getLambda7$material3_release()
            goto L_0x0149
        L_0x0148:
            r3 = r5
        L_0x0149:
            if (r6 == 0) goto L_0x0152
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1870getLambda8$material3_release()
            r7 = r4
        L_0x0152:
            r4 = r40 & 16
            if (r4 == 0) goto L_0x015e
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r9, r0)
            r1 = r1 & r14
            r10 = r4
        L_0x015e:
            r4 = r40 & 32
            if (r4 == 0) goto L_0x017c
            androidx.compose.material3.TopAppBarDefaults r14 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r4 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 31
            r15 = r4
            r25 = r9
            androidx.compose.material3.TopAppBarColors r4 = r14.m2250mediumTopAppBarColorszjMxDiM(r15, r17, r19, r21, r23, r25, r26, r27)
            r1 = r1 & r30
            r11 = r4
        L_0x017c:
            if (r28 == 0) goto L_0x018d
            r4 = 0
            r8 = r1
            r17 = r2
            r18 = r3
            r22 = r4
            r19 = r7
            r20 = r10
            r21 = r11
            goto L_0x019a
        L_0x018d:
            r22 = r37
            r8 = r1
            r17 = r2
            r18 = r3
            r19 = r7
            r20 = r10
            r21 = r11
        L_0x019a:
            r9.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ac
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.MediumTopAppBar (AppBar.kt:279)"
            r3 = 1805417862(0x6b9c7d86, float:3.783704E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r1, r2)
        L_0x01ac:
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r1 = r1.getTypography(r9, r0)
            androidx.compose.material3.tokens.TopAppBarMediumTokens r2 = androidx.compose.material3.tokens.TopAppBarMediumTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r2 = r2.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.material3.TypographyKt.fromToken(r1, r2)
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r0 = r1.getTypography(r9, r0)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r1 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r1 = r1.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.material3.TypographyKt.fromToken(r0, r1)
            float r3 = MediumTitleBottomPadding
            androidx.compose.material3.tokens.TopAppBarMediumTokens r0 = androidx.compose.material3.tokens.TopAppBarMediumTokens.INSTANCE
            float r10 = r0.m2702getContainerHeightD9Ej5fM()
            androidx.compose.material3.tokens.TopAppBarSmallTokens r0 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            float r11 = r0.m2712getContainerHeightD9Ej5fM()
            int r0 = r8 >> 3
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r8 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r8 << 12
            r4 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r8 << 12
            r1 = r1 & r29
            r0 = r0 | r1
            int r1 = r8 << 12
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r8 << 12
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r8 << 12
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r4
            r14 = r0 | r1
            int r0 = r8 >> 12
            r0 = r0 & 896(0x380, float:1.256E-42)
            r15 = r0 | 54
            r16 = 0
            r0 = r17
            r1 = r31
            r4 = r31
            r6 = r18
            r7 = r19
            r23 = r8
            r8 = r20
            r24 = r9
            r9 = r21
            r12 = r22
            r13 = r24
            m1746TwoRowsTopAppBartjU4iQQ(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x023a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x023a:
            r10 = r20
            r11 = r21
        L_0x023e:
            androidx.compose.runtime.ScopeUpdateScope r12 = r24.endRestartGroup()
            if (r12 != 0) goto L_0x0245
            goto L_0x0260
        L_0x0245:
            androidx.compose.material3.AppBarKt$MediumTopAppBar$1 r13 = new androidx.compose.material3.AppBarKt$MediumTopAppBar$1
            r0 = r13
            r1 = r31
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r10
            r6 = r11
            r7 = r22
            r8 = r39
            r9 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0260:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.MediumTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LargeTopAppBar(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.ui.Modifier r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.foundation.layout.WindowInsets r35, androidx.compose.material3.TopAppBarColors r36, androidx.compose.material3.TopAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r13 = r31
            r12 = r39
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -474540752(0xffffffffe3b71530, float:-6.754562E21)
            r1 = r38
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LargeTopAppBar)P(5,2,3!1,6)342@17629L12,343@17691L22,348@17855L10,349@17956L10,346@17775L643:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r39
            r2 = r40 & 1
            if (r2 == 0) goto L_0x0021
            r1 = r1 | 6
            goto L_0x002f
        L_0x0021:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r9.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x002d
            r2 = 4
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r1 = r1 | r2
        L_0x002f:
            r2 = r40 & 2
            if (r2 == 0) goto L_0x0038
            r1 = r1 | 48
            r3 = r32
            goto L_0x004d
        L_0x0038:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            r3 = r32
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0047
            r4 = 32
            goto L_0x0049
        L_0x0047:
            r4 = 16
        L_0x0049:
            r1 = r1 | r4
            goto L_0x004d
        L_0x004b:
            r3 = r32
        L_0x004d:
            r4 = r40 & 4
            if (r4 == 0) goto L_0x0056
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r33
            goto L_0x006b
        L_0x0056:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r33
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0065
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r6
            goto L_0x006b
        L_0x0069:
            r5 = r33
        L_0x006b:
            r6 = r40 & 8
            if (r6 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r34
            goto L_0x0089
        L_0x0074:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0087
            r7 = r34
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0083
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r8
            goto L_0x0089
        L_0x0087:
            r7 = r34
        L_0x0089:
            r8 = 57344(0xe000, float:8.0356E-41)
            r10 = r12 & r8
            if (r10 != 0) goto L_0x00a5
            r10 = r40 & 16
            if (r10 != 0) goto L_0x009f
            r10 = r35
            boolean r11 = r9.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x00a1
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r10 = r35
        L_0x00a1:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r11
            goto L_0x00a7
        L_0x00a5:
            r10 = r35
        L_0x00a7:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r12
            if (r11 != 0) goto L_0x00c1
            r11 = r40 & 32
            if (r11 != 0) goto L_0x00bb
            r11 = r36
            boolean r14 = r9.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x00bd
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bb:
            r11 = r36
        L_0x00bd:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r1 = r1 | r14
            goto L_0x00c3
        L_0x00c1:
            r11 = r36
        L_0x00c3:
            r28 = r40 & 64
            r29 = 3670016(0x380000, float:5.142788E-39)
            if (r28 == 0) goto L_0x00cf
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            r15 = r37
            goto L_0x00e4
        L_0x00cf:
            r14 = r12 & r29
            if (r14 != 0) goto L_0x00e2
            r15 = r37
            boolean r14 = r9.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00de
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r1 = r1 | r14
            goto L_0x00e4
        L_0x00e2:
            r15 = r37
        L_0x00e4:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r1
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r8) goto L_0x0105
            boolean r8 = r9.getSkipping()
            if (r8 != 0) goto L_0x00f4
            goto L_0x0105
        L_0x00f4:
            r9.skipToGroupEnd()
            r23 = r1
            r17 = r3
            r18 = r5
            r19 = r7
            r24 = r9
            r22 = r15
            goto L_0x023e
        L_0x0105:
            r9.startDefaults()
            r8 = r12 & 1
            r30 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = 6
            if (r8 == 0) goto L_0x0137
            boolean r8 = r9.getDefaultsInvalid()
            if (r8 == 0) goto L_0x011a
            goto L_0x0137
        L_0x011a:
            r9.skipToGroupEnd()
            r2 = r40 & 16
            if (r2 == 0) goto L_0x0122
            r1 = r1 & r14
        L_0x0122:
            r2 = r40 & 32
            if (r2 == 0) goto L_0x0128
            r1 = r1 & r30
        L_0x0128:
            r8 = r1
            r17 = r3
            r18 = r5
            r19 = r7
            r20 = r10
            r21 = r11
            r22 = r15
            goto L_0x019a
        L_0x0137:
            if (r2 == 0) goto L_0x013e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x013f
        L_0x013e:
            r2 = r3
        L_0x013f:
            if (r4 == 0) goto L_0x0148
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1871getLambda9$material3_release()
            goto L_0x0149
        L_0x0148:
            r3 = r5
        L_0x0149:
            if (r6 == 0) goto L_0x0152
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1861getLambda10$material3_release()
            r7 = r4
        L_0x0152:
            r4 = r40 & 16
            if (r4 == 0) goto L_0x015e
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r9, r0)
            r1 = r1 & r14
            r10 = r4
        L_0x015e:
            r4 = r40 & 32
            if (r4 == 0) goto L_0x017c
            androidx.compose.material3.TopAppBarDefaults r14 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r4 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 31
            r15 = r4
            r25 = r9
            androidx.compose.material3.TopAppBarColors r4 = r14.m2249largeTopAppBarColorszjMxDiM(r15, r17, r19, r21, r23, r25, r26, r27)
            r1 = r1 & r30
            r11 = r4
        L_0x017c:
            if (r28 == 0) goto L_0x018d
            r4 = 0
            r8 = r1
            r17 = r2
            r18 = r3
            r22 = r4
            r19 = r7
            r20 = r10
            r21 = r11
            goto L_0x019a
        L_0x018d:
            r22 = r37
            r8 = r1
            r17 = r2
            r18 = r3
            r19 = r7
            r20 = r10
            r21 = r11
        L_0x019a:
            r9.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ac
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.LargeTopAppBar (AppBar.kt:337)"
            r3 = -474540752(0xffffffffe3b71530, float:-6.754562E21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r1, r2)
        L_0x01ac:
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r1 = r1.getTypography(r9, r0)
            androidx.compose.material3.tokens.TopAppBarLargeTokens r2 = androidx.compose.material3.tokens.TopAppBarLargeTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r2 = r2.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.material3.TypographyKt.fromToken(r1, r2)
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r0 = r1.getTypography(r9, r0)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r1 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r1 = r1.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.material3.TypographyKt.fromToken(r0, r1)
            float r3 = LargeTitleBottomPadding
            androidx.compose.material3.tokens.TopAppBarLargeTokens r0 = androidx.compose.material3.tokens.TopAppBarLargeTokens.INSTANCE
            float r10 = r0.m2698getContainerHeightD9Ej5fM()
            androidx.compose.material3.tokens.TopAppBarSmallTokens r0 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            float r11 = r0.m2712getContainerHeightD9Ej5fM()
            int r0 = r8 >> 3
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r8 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r8 << 12
            r4 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r8 << 12
            r1 = r1 & r29
            r0 = r0 | r1
            int r1 = r8 << 12
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r8 << 12
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r4
            r0 = r0 | r1
            int r1 = r8 << 12
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r4
            r14 = r0 | r1
            int r0 = r8 >> 12
            r0 = r0 & 896(0x380, float:1.256E-42)
            r15 = r0 | 54
            r16 = 0
            r0 = r17
            r1 = r31
            r4 = r31
            r6 = r18
            r7 = r19
            r23 = r8
            r8 = r20
            r24 = r9
            r9 = r21
            r12 = r22
            r13 = r24
            m1746TwoRowsTopAppBartjU4iQQ(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x023a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x023a:
            r10 = r20
            r11 = r21
        L_0x023e:
            androidx.compose.runtime.ScopeUpdateScope r12 = r24.endRestartGroup()
            if (r12 != 0) goto L_0x0245
            goto L_0x0260
        L_0x0245:
            androidx.compose.material3.AppBarKt$LargeTopAppBar$1 r13 = new androidx.compose.material3.AppBarKt$LargeTopAppBar$1
            r0 = r13
            r1 = r31
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r10
            r6 = r11
            r7 = r22
            r8 = r39
            r9 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0260:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.LargeTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: BottomAppBar-Snr_uVM  reason: not valid java name */
    public static final void m1743BottomAppBarSnr_uVM(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, Composer $composer, int $changed, int i) {
        Function2 floatingActionButton2;
        long containerColor2;
        long contentColor2;
        float tonalElevation2;
        WindowInsets windowInsets2;
        PaddingValues contentPadding2;
        float tonalElevation3;
        long contentColor3;
        long containerColor3;
        Function2 floatingActionButton3;
        Modifier modifier2;
        WindowInsets windowInsets3;
        PaddingValues contentPadding3;
        Modifier modifier3;
        int i2;
        int i3;
        int i4;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = actions;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function3, "actions");
        Composer $composer2 = $composer.startRestartGroup(2141738945);
        ComposerKt.sourceInformation($composer2, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)398@20381L14,399@20423L31,402@20649L12,403@20667L634:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i6 & 1) != 0) {
            $dirty |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty |= $composer2.changed((Object) function3) ? 4 : 2;
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
        int i8 = i6 & 4;
        if (i8 != 0) {
            $dirty |= 384;
            floatingActionButton2 = floatingActionButton;
        } else if ((i5 & 896) == 0) {
            floatingActionButton2 = floatingActionButton;
            $dirty |= $composer2.changed((Object) floatingActionButton2) ? 256 : 128;
        } else {
            floatingActionButton2 = floatingActionButton;
        }
        if ((i5 & 7168) == 0) {
            if ((i6 & 8) == 0) {
                containerColor2 = containerColor;
                if ($composer2.changed(containerColor2)) {
                    i4 = 2048;
                    $dirty |= i4;
                }
            } else {
                containerColor2 = containerColor;
            }
            i4 = 1024;
            $dirty |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if ((i5 & 57344) == 0) {
            if ((i6 & 16) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i3 = 16384;
                    $dirty |= i3;
                }
            } else {
                contentColor2 = contentColor;
            }
            i3 = 8192;
            $dirty |= i3;
        } else {
            contentColor2 = contentColor;
        }
        int i9 = i6 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            tonalElevation2 = tonalElevation;
        } else if ((i5 & 458752) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty |= $composer2.changed(tonalElevation2) ? 131072 : 65536;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i10 = i6 & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            PaddingValues paddingValues = contentPadding;
        } else if ((i5 & 3670016) == 0) {
            $dirty |= $composer2.changed((Object) contentPadding) ? 1048576 : 524288;
        } else {
            PaddingValues paddingValues2 = contentPadding;
        }
        if ((i5 & 29360128) == 0) {
            if ((i6 & 128) != 0) {
                WindowInsets windowInsets4 = windowInsets;
            } else if ($composer2.changed((Object) windowInsets)) {
                i2 = 8388608;
                $dirty |= i2;
            }
            i2 = 4194304;
            $dirty |= i2;
        } else {
            WindowInsets windowInsets5 = windowInsets;
        }
        if (($dirty & 23967451) != 4793490 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    floatingActionButton2 = null;
                }
                if ((i6 & 8) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -7169;
                }
                if ((i6 & 16) != 0) {
                    contentColor2 = ColorSchemeKt.m1854contentColorForek8zF_U(containerColor2, $composer2, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                }
                if (i9 != 0) {
                    tonalElevation2 = BottomAppBarDefaults.INSTANCE.m1761getContainerElevationD9Ej5fM();
                }
                if (i10 != 0) {
                    contentPadding3 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding3 = contentPadding;
                }
                if ((i6 & 128) != 0) {
                    windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty &= -29360129;
                } else {
                    windowInsets3 = windowInsets;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i6 & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i6 & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i6 & 128) != 0) {
                    contentPadding3 = contentPadding;
                    windowInsets3 = windowInsets;
                    $dirty &= -29360129;
                    modifier3 = modifier;
                } else {
                    modifier3 = modifier;
                    contentPadding3 = contentPadding;
                    windowInsets3 = windowInsets;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2141738945, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:394)");
            }
            m1742BottomAppBar1oL4kX8(modifier3, containerColor2, contentColor2, tonalElevation2, contentPadding3, windowInsets3, ComposableLambdaKt.composableLambda($composer2, 1974005449, true, new AppBarKt$BottomAppBar$1(function3, $dirty, floatingActionButton2)), $composer2, (($dirty >> 3) & 14) | 1572864 | (($dirty >> 6) & 112) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            int i11 = $dirty;
            contentPadding2 = contentPadding3;
            windowInsets2 = windowInsets3;
            floatingActionButton3 = floatingActionButton2;
            containerColor3 = containerColor2;
            tonalElevation3 = tonalElevation2;
            contentColor3 = contentColor2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            contentPadding2 = contentPadding;
            windowInsets2 = windowInsets;
            int i12 = $dirty;
            floatingActionButton3 = floatingActionButton2;
            containerColor3 = containerColor2;
            tonalElevation3 = tonalElevation2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new AppBarKt$BottomAppBar$2(actions, modifier2, floatingActionButton3, containerColor3, contentColor3, tonalElevation3, contentPadding2, windowInsets2, $changed, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0107  */
    /* renamed from: BottomAppBar-1oL4kX8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1742BottomAppBar1oL4kX8(androidx.compose.ui.Modifier r27, long r28, long r30, float r32, androidx.compose.foundation.layout.PaddingValues r33, androidx.compose.foundation.layout.WindowInsets r34, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r12 = r35
            r13 = r37
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            r1 = r36
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,3,6)456@22922L14,457@22964L31,460@23190L12,468@23524L9,463@23257L693:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r37
            r2 = r38 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r27
            goto L_0x0035
        L_0x0022:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r27
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r27
        L_0x0035:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r38 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r28
            boolean r6 = r11.changed((long) r4)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r28
        L_0x004a:
            r6 = 16
        L_0x004c:
            r1 = r1 | r6
            goto L_0x0050
        L_0x004e:
            r4 = r28
        L_0x0050:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0069
            r6 = r38 & 4
            if (r6 != 0) goto L_0x0063
            r6 = r30
            boolean r8 = r11.changed((long) r6)
            if (r8 == 0) goto L_0x0065
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r6 = r30
        L_0x0065:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r8
            goto L_0x006b
        L_0x0069:
            r6 = r30
        L_0x006b:
            r8 = r38 & 8
            if (r8 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r32
            goto L_0x0089
        L_0x0074:
            r9 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0087
            r9 = r32
            boolean r10 = r11.changed((float) r9)
            if (r10 == 0) goto L_0x0083
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r10
            goto L_0x0089
        L_0x0087:
            r9 = r32
        L_0x0089:
            r10 = r38 & 16
            r14 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0095
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r15 = r33
            goto L_0x00ab
        L_0x0095:
            r15 = r13 & r14
            if (r15 != 0) goto L_0x00a9
            r15 = r33
            boolean r16 = r11.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00a4
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r16
            goto L_0x00ab
        L_0x00a9:
            r15 = r33
        L_0x00ab:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00c7
            r16 = r38 & 32
            if (r16 != 0) goto L_0x00c0
            r14 = r34
            boolean r16 = r11.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x00c2
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c0:
            r14 = r34
        L_0x00c2:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r16
            goto L_0x00c9
        L_0x00c7:
            r14 = r34
        L_0x00c9:
            r16 = r38 & 64
            if (r16 == 0) goto L_0x00d2
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00cf:
            r1 = r1 | r16
            goto L_0x00e4
        L_0x00d2:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00e4
            boolean r16 = r11.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00e1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00e1:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00cf
        L_0x00e4:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r16
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x0107
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x00f5
            goto L_0x0107
        L_0x00f5:
            r11.skipToGroupEnd()
            r22 = r1
            r17 = r6
            r19 = r9
            r21 = r14
            r20 = r15
            r14 = r27
            r15 = r4
            goto L_0x01f1
        L_0x0107:
            r11.startDefaults()
            r0 = r13 & 1
            r3 = 6
            if (r0 == 0) goto L_0x0139
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0116
            goto L_0x0139
        L_0x0116:
            r11.skipToGroupEnd()
            r0 = r38 & 2
            if (r0 == 0) goto L_0x011f
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x011f:
            r0 = r38 & 4
            if (r0 == 0) goto L_0x0125
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0125:
            r0 = r38 & 32
            if (r0 == 0) goto L_0x0133
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
            r8 = r0
            r2 = r14
            r1 = r15
            r0 = r27
            goto L_0x0182
        L_0x0133:
            r0 = r27
            r8 = r1
            r2 = r14
            r1 = r15
            goto L_0x0182
        L_0x0139:
            if (r2 == 0) goto L_0x0140
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0142
        L_0x0140:
            r0 = r27
        L_0x0142:
            r2 = r38 & 2
            if (r2 == 0) goto L_0x014e
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r4 = r2.getContainerColor(r11, r3)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x014e:
            r2 = r38 & 4
            if (r2 == 0) goto L_0x015c
            int r2 = r1 >> 3
            r2 = r2 & 14
            long r6 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r4, r11, r2)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x015c:
            if (r8 == 0) goto L_0x0165
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r2 = r2.m1761getContainerElevationD9Ej5fM()
            r9 = r2
        L_0x0165:
            if (r10 == 0) goto L_0x016e
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r2 = r2.getContentPadding()
            r15 = r2
        L_0x016e:
            r2 = r38 & 32
            if (r2 == 0) goto L_0x017f
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r11, r3)
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r8
            r8 = r1
            r1 = r15
            goto L_0x0182
        L_0x017f:
            r8 = r1
            r2 = r14
            r1 = r15
        L_0x0182:
            r11.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0194
            r10 = -1
            java.lang.String r14 = "androidx.compose.material3.BottomAppBar (AppBar.kt:454)"
            r15 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r8, r10, r14)
        L_0x0194:
            androidx.compose.material3.tokens.BottomAppBarTokens r10 = androidx.compose.material3.tokens.BottomAppBarTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r10 = r10.getContainerShape()
            androidx.compose.ui.graphics.Shape r15 = androidx.compose.material3.ShapesKt.toShape(r10, r11, r3)
            r21 = 0
            r22 = 0
            androidx.compose.material3.AppBarKt$BottomAppBar$3 r3 = new androidx.compose.material3.AppBarKt$BottomAppBar$3
            r3.<init>(r2, r1, r12, r8)
            r10 = -396569832(0xffffffffe85cd318, float:-4.1712585E24)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r10, r14, r3)
            r23 = r3
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            r3 = r8 & 14
            r10 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r10
            int r10 = r8 << 3
            r10 = r10 & 896(0x380, float:1.256E-42)
            r3 = r3 | r10
            int r10 = r8 << 3
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r10
            int r10 = r8 << 3
            r14 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r14
            r25 = r3 | r10
            r26 = 96
            r14 = r0
            r16 = r4
            r18 = r6
            r20 = r9
            r24 = r11
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r26)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01e5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e5:
            r14 = r0
            r20 = r1
            r21 = r2
            r15 = r4
            r17 = r6
            r22 = r8
            r19 = r9
        L_0x01f1:
            androidx.compose.runtime.ScopeUpdateScope r10 = r11.endRestartGroup()
            if (r10 != 0) goto L_0x01fa
            r24 = r11
            goto L_0x021b
        L_0x01fa:
            androidx.compose.material3.AppBarKt$BottomAppBar$4 r23 = new androidx.compose.material3.AppBarKt$BottomAppBar$4
            r0 = r23
            r1 = r14
            r2 = r15
            r4 = r17
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r35
            r12 = r10
            r10 = r37
            r24 = r11
            r11 = r38
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x021b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1742BottomAppBar1oL4kX8(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b2  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.TopAppBarState rememberTopAppBarState(float r18, float r19, float r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r7 = r21
            r8 = r22
            r0 = 1801969826(0x6b67e0a2, float:2.8032266E26)
            r7.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberTopAppBarState)P(2,1)760@36816L145,760@36769L192:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r23 & 1
            if (r1 == 0) goto L_0x0018
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r9 = r1
            goto L_0x001a
        L_0x0018:
            r9 = r18
        L_0x001a:
            r1 = r23 & 2
            if (r1 == 0) goto L_0x0021
            r1 = 0
            r10 = r1
            goto L_0x0023
        L_0x0021:
            r10 = r19
        L_0x0023:
            r1 = r23 & 4
            if (r1 == 0) goto L_0x002a
            r1 = 0
            r11 = r1
            goto L_0x002c
        L_0x002a:
            r11 = r20
        L_0x002c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0038
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:755)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r1, r2)
        L_0x0038:
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            androidx.compose.material3.TopAppBarState$Companion r1 = androidx.compose.material3.TopAppBarState.Companion
            androidx.compose.runtime.saveable.Saver r1 = r1.getSaver()
            java.lang.Float r3 = java.lang.Float.valueOf(r9)
            java.lang.Float r4 = java.lang.Float.valueOf(r10)
            java.lang.Float r5 = java.lang.Float.valueOf(r11)
            r6 = r8 & 14
            r12 = r8 & 112(0x70, float:1.57E-43)
            r6 = r6 | r12
            r12 = r8 & 896(0x380, float:1.256E-42)
            r6 = r6 | r12
            r12 = 0
            r13 = 1618982084(0x607fb4c4, float:7.370227E19)
            r7.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r13)
            boolean r13 = r7.changed((java.lang.Object) r3)
            boolean r14 = r7.changed((java.lang.Object) r4)
            r13 = r13 | r14
            boolean r14 = r7.changed((java.lang.Object) r5)
            r13 = r13 | r14
            r14 = r21
            r15 = 0
            java.lang.Object r2 = r14.rememberedValue()
            r16 = 0
            if (r13 != 0) goto L_0x0088
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r19 = r3
            java.lang.Object r3 = r17.getEmpty()
            if (r2 != r3) goto L_0x0085
            goto L_0x008a
        L_0x0085:
            r20 = r2
            goto L_0x0098
        L_0x0088:
            r19 = r3
        L_0x008a:
            r3 = 0
            r20 = r2
            androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1 r2 = new androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
            r2.<init>(r9, r10, r11)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r14.updateRememberedValue(r2)
        L_0x0098:
            r21.endReplaceableGroup()
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r5 = 72
            r6 = 4
            r2 = 0
            r4 = r21
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.TopAppBarState r0 = (androidx.compose.material3.TopAppBarState) r0
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00b5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b5:
            r21.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.rememberTopAppBarState(float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.TopAppBarState");
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x034f  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SingleRowTopAppBar(androidx.compose.ui.Modifier r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.text.TextStyle r39, boolean r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.foundation.layout.WindowInsets r43, androidx.compose.material3.TopAppBarColors r44, androidx.compose.material3.TopAppBarScrollBehavior r45, androidx.compose.runtime.Composer r46, int r47, int r48) {
        /*
            r12 = r42
            r13 = r44
            r14 = r45
            r15 = r47
            r11 = r48
            r0 = 1841601619(0x6dc49c53, float:7.606006E27)
            r1 = r46
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SingleRowTopAppBar)P(3,6,7,1,4!1,8)*996@45438L7,997@45511L167,997@45500L178,1010@46274L24,1009@46224L151,1047@47681L1166:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r47
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0023
            r1 = r1 | 6
            r3 = r37
            goto L_0x0036
        L_0x0023:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0034
            r3 = r37
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0031
            r4 = 4
            goto L_0x0032
        L_0x0031:
            r4 = 2
        L_0x0032:
            r1 = r1 | r4
            goto L_0x0036
        L_0x0034:
            r3 = r37
        L_0x0036:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x003f
            r1 = r1 | 48
            r9 = r38
            goto L_0x0054
        L_0x003f:
            r4 = r15 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0052
            r9 = r38
            boolean r4 = r10.changed((java.lang.Object) r9)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r1 = r1 | r4
            goto L_0x0054
        L_0x0052:
            r9 = r38
        L_0x0054:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r8 = r39
            goto L_0x0072
        L_0x005d:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0070
            r8 = r39
            boolean r4 = r10.changed((java.lang.Object) r8)
            if (r4 == 0) goto L_0x006c
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r4 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r4
            goto L_0x0072
        L_0x0070:
            r8 = r39
        L_0x0072:
            r4 = r11 & 8
            if (r4 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r40
            goto L_0x0090
        L_0x007b:
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x008e
            r7 = r40
            boolean r4 = r10.changed((boolean) r7)
            if (r4 == 0) goto L_0x008a
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r4
            goto L_0x0090
        L_0x008e:
            r7 = r40
        L_0x0090:
            r4 = r11 & 16
            if (r4 == 0) goto L_0x0099
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r6 = r41
            goto L_0x00b0
        L_0x0099:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r15
            if (r4 != 0) goto L_0x00ae
            r6 = r41
            boolean r4 = r10.changed((java.lang.Object) r6)
            if (r4 == 0) goto L_0x00aa
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r1 = r1 | r4
            goto L_0x00b0
        L_0x00ae:
            r6 = r41
        L_0x00b0:
            r4 = r11 & 32
            if (r4 == 0) goto L_0x00b8
            r4 = 196608(0x30000, float:2.75506E-40)
        L_0x00b6:
            r1 = r1 | r4
            goto L_0x00c9
        L_0x00b8:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r15
            if (r4 != 0) goto L_0x00c9
            boolean r4 = r10.changed((java.lang.Object) r12)
            if (r4 == 0) goto L_0x00c6
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00c6:
            r4 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b6
        L_0x00c9:
            r4 = r11 & 64
            if (r4 == 0) goto L_0x00d3
            r4 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r4
            r5 = r43
            goto L_0x00e9
        L_0x00d3:
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r15
            if (r4 != 0) goto L_0x00e7
            r5 = r43
            boolean r4 = r10.changed((java.lang.Object) r5)
            if (r4 == 0) goto L_0x00e3
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r4 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r1 = r1 | r4
            goto L_0x00e9
        L_0x00e7:
            r5 = r43
        L_0x00e9:
            r4 = r11 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00f1
            r4 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ef:
            r1 = r1 | r4
            goto L_0x0102
        L_0x00f1:
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r15
            if (r4 != 0) goto L_0x0102
            boolean r4 = r10.changed((java.lang.Object) r13)
            if (r4 == 0) goto L_0x00ff
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ff:
            r4 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ef
        L_0x0102:
            r4 = r11 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x010a
            r4 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0108:
            r1 = r1 | r4
            goto L_0x011b
        L_0x010a:
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r15
            if (r4 != 0) goto L_0x011b
            boolean r4 = r10.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x0118
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0108
        L_0x0118:
            r4 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0108
        L_0x011b:
            r4 = r1
            r1 = 191739611(0xb6db6db, float:4.5782105E-32)
            r1 = r1 & r4
            r0 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r0) goto L_0x0135
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x012c
            goto L_0x0135
        L_0x012c:
            r10.skipToGroupEnd()
            r30 = r3
            r35 = r4
            goto L_0x0352
        L_0x0135:
            if (r2 == 0) goto L_0x013c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x013d
        L_0x013c:
            r0 = r3
        L_0x013d:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x014c
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:982)"
            r3 = 1841601619(0x6dc49c53, float:7.606006E27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r1, r2)
        L_0x014c:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 0
            r3 = 0
            r37 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            r46 = r3
            java.lang.String r3 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r3)
            java.lang.Object r2 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r1 = r2
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            r2 = 0
            androidx.compose.material3.tokens.TopAppBarSmallTokens r3 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            float r3 = r3.m2712getContainerHeightD9Ej5fM()
            float r3 = r1.m5967toPx0680j_4(r3)
            float r1 = -r3
            r3 = r1
            java.lang.Float r1 = java.lang.Float.valueOf(r3)
            int r2 = r4 >> 24
            r2 = r2 & 14
            r16 = 0
            r37 = r2
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            boolean r2 = r10.changed((java.lang.Object) r14)
            boolean r17 = r10.changed((java.lang.Object) r1)
            r2 = r2 | r17
            r46 = r10
            r17 = 0
            r18 = r1
            java.lang.Object r1 = r46.rememberedValue()
            r19 = 0
            if (r2 != 0) goto L_0x01b7
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r1 != r2) goto L_0x01b2
            goto L_0x01b9
        L_0x01b2:
            r2 = r46
            r20 = r1
            goto L_0x01c9
        L_0x01b7:
            r21 = r2
        L_0x01b9:
            r2 = 0
            r20 = r1
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1 r1 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
            r1.<init>(r14, r3)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r2 = r46
            r2.updateRememberedValue(r1)
        L_0x01c9:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r2 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r1, r10, r2)
            r1 = 0
            if (r14 == 0) goto L_0x01e2
            androidx.compose.material3.TopAppBarState r16 = r45.getState()
            if (r16 == 0) goto L_0x01e2
            float r16 = r16.getOverlappedFraction()
            goto L_0x01e4
        L_0x01e2:
            r16 = r1
        L_0x01e4:
            r29 = r16
            r16 = 1008981770(0x3c23d70a, float:0.01)
            int r16 = (r29 > r16 ? 1 : (r29 == r16 ? 0 : -1))
            if (r16 <= 0) goto L_0x01f0
            r16 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01f2
        L_0x01f0:
            r16 = r1
        L_0x01f2:
            r37 = r16
            int r16 = r4 >> 18
            r2 = r16 & 112(0x70, float:1.57E-43)
            r7 = r37
            long r16 = r13.m2244containerColorXeAY9LY$material3_release(r7, r10, r2)
            r2 = 1137180672(0x43c80000, float:400.0)
            r37 = r3
            r3 = 5
            r18 = r7
            r7 = 0
            androidx.compose.animation.core.SpringSpec r1 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r1, r2, r7, r3, r7)
            r3 = r1
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r19 = 0
            r20 = 48
            r21 = 4
            r1 = r16
            r31 = r37
            r32 = r4
            r4 = r19
            r5 = r10
            r6 = r20
            r8 = r7
            r33 = r18
            r7 = r21
            androidx.compose.runtime.State r34 = androidx.compose.animation.SingleValueAnimationKt.m362animateColorAsStateKTwxG1Y(r1, r3, r4, r5, r6, r7)
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1 r1 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
            r7 = r32
            r1.<init>(r12, r7)
            r2 = 1520880938(0x5aa6cd2a, float:2.34752132E16)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r2, r6, r1)
            r32 = r1
            kotlin.jvm.functions.Function2 r32 = (kotlin.jvm.functions.Function2) r32
            r1 = -1008378142(0xffffffffc3e55ee2, float:-458.74127)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "1027@46923L118,1027@46900L141,1030@47071L255"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            if (r14 == 0) goto L_0x02fb
            boolean r1 = r45.isPinned()
            if (r1 != 0) goto L_0x02fb
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r18 = androidx.compose.foundation.gestures.Orientation.Vertical
            int r2 = r7 >> 24
            r2 = r2 & 14
            r3 = 0
            r4 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r4)
            java.lang.String r5 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            boolean r16 = r10.changed((java.lang.Object) r14)
            r37 = r10
            r17 = 0
            java.lang.Object r6 = r37.rememberedValue()
            r19 = 0
            if (r16 != 0) goto L_0x027f
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r20.getEmpty()
            if (r6 != r8) goto L_0x027b
            goto L_0x027f
        L_0x027b:
            r8 = r37
            r4 = r6
            goto L_0x028d
        L_0x027f:
            r8 = 0
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1 r4 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1
            r4.<init>(r14)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r8 = r37
            r8.updateRememberedValue(r4)
        L_0x028d:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r2 = 0
            androidx.compose.foundation.gestures.DraggableState r17 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r4, r10, r2)
            r16 = r1
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            r19 = 0
            r22 = 0
            int r3 = r7 >> 24
            r3 = r3 & 14
            r3 = r3 | 64
            r4 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            boolean r5 = r10.changed((java.lang.Object) r14)
            r6 = r10
            r8 = 0
            java.lang.Object r2 = r6.rememberedValue()
            r20 = 0
            if (r5 != 0) goto L_0x02cf
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r23.getEmpty()
            if (r2 != r1) goto L_0x02cb
            goto L_0x02cf
        L_0x02cb:
            r1 = r2
            r25 = r1
            goto L_0x02e0
        L_0x02cf:
            r1 = 0
            r23 = r1
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1 r1 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1
            r25 = r2
            r2 = 0
            r1.<init>(r14, r2)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r6.updateRememberedValue(r1)
        L_0x02e0:
            r10.endReplaceableGroup()
            r23 = r1
            kotlin.jvm.functions.Function3 r23 = (kotlin.jvm.functions.Function3) r23
            r1 = 0
            r25 = 188(0xbc, float:2.63E-43)
            r26 = 0
            r2 = 0
            r20 = r2
            r2 = 0
            r21 = r2
            r24 = r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x02ff
        L_0x02fb:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x02ff:
            r10.endReplaceableGroup()
            r8 = r1
            androidx.compose.ui.Modifier r16 = r0.then(r8)
            r17 = 0
            long r18 = m1744SingleRowTopAppBar$lambda3(r34)
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2 r6 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
            r30 = r0
            r0 = r6
            r1 = r43
            r2 = r44
            r3 = r38
            r4 = r39
            r5 = r40
            r11 = r6
            r12 = 1
            r6 = r41
            r35 = r7
            r7 = r32
            r36 = r8
            r8 = r35
            r9 = r45
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 376925230(0x16776c2e, float:1.9986637E-25)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r0, r12, r11)
            r25 = r0
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r28 = 122(0x7a, float:1.71E-43)
            r26 = r10
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27, r28)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0352
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0352:
            androidx.compose.runtime.ScopeUpdateScope r12 = r10.endRestartGroup()
            if (r12 != 0) goto L_0x035b
            r17 = r10
            goto L_0x0381
        L_0x035b:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3 r16 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3
            r0 = r16
            r1 = r30
            r2 = r38
            r3 = r39
            r4 = r40
            r5 = r41
            r6 = r42
            r7 = r43
            r8 = r44
            r9 = r45
            r17 = r10
            r10 = r47
            r11 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0381:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SingleRowTopAppBar(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: SingleRowTopAppBar$lambda-3  reason: not valid java name */
    private static final long m1744SingleRowTopAppBar$lambda3(State<Color> $appBarContainerColor$delegate) {
        return ((Color) $appBarContainerColor$delegate.getValue()).m3174unboximpl();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v4, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0419  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0420  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0145  */
    /* renamed from: TwoRowsTopAppBar-tjU4iQQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1746TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.ui.text.TextStyle r47, float r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.ui.text.TextStyle r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.foundation.layout.WindowInsets r53, androidx.compose.material3.TopAppBarColors r54, float r55, float r56, androidx.compose.material3.TopAppBarScrollBehavior r57, androidx.compose.runtime.Composer r58, int r59, int r60, int r61) {
        /*
            r15 = r48
            r14 = r52
            r13 = r54
            r12 = r55
            r11 = r56
            r10 = r57
            r9 = r59
            r8 = r60
            r7 = r61
            r0 = 210227552(0xc87d160, float:2.0926056E-31)
            r1 = r58
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TwoRowsTopAppBar)P(3,9,11,10:c#ui.unit.Dp,7,8,4!1,12!1,2:c#ui.unit.Dp,5:c#ui.unit.Dp)*1107@49894L7,1115@50207L189,1115@50196L200,1127@50927L39,1127@50899L68,1164@52391L2049:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r59
            r2 = r60
            r3 = r7 & 1
            if (r3 == 0) goto L_0x002d
            r1 = r1 | 6
            r4 = r45
            goto L_0x0043
        L_0x002d:
            r16 = r9 & 14
            if (r16 != 0) goto L_0x0041
            r4 = r45
            boolean r16 = r6.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x003c
            r16 = 4
            goto L_0x003e
        L_0x003c:
            r16 = 2
        L_0x003e:
            r1 = r1 | r16
            goto L_0x0043
        L_0x0041:
            r4 = r45
        L_0x0043:
            r16 = r7 & 2
            r17 = 32
            r18 = 16
            if (r16 == 0) goto L_0x0050
            r1 = r1 | 48
            r0 = r46
            goto L_0x0066
        L_0x0050:
            r16 = r9 & 112(0x70, float:1.57E-43)
            if (r16 != 0) goto L_0x0064
            r0 = r46
            boolean r19 = r6.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x005f
            r19 = r17
            goto L_0x0061
        L_0x005f:
            r19 = r18
        L_0x0061:
            r1 = r1 | r19
            goto L_0x0066
        L_0x0064:
            r0 = r46
        L_0x0066:
            r19 = r7 & 4
            r20 = 256(0x100, float:3.59E-43)
            r21 = 128(0x80, float:1.794E-43)
            if (r19 == 0) goto L_0x0073
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r47
            goto L_0x0089
        L_0x0073:
            r5 = r9 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0087
            r5 = r47
            boolean r22 = r6.changed((java.lang.Object) r5)
            if (r22 == 0) goto L_0x0082
            r22 = r20
            goto L_0x0084
        L_0x0082:
            r22 = r21
        L_0x0084:
            r1 = r1 | r22
            goto L_0x0089
        L_0x0087:
            r5 = r47
        L_0x0089:
            r22 = r7 & 8
            if (r22 == 0) goto L_0x0090
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x00a0
        L_0x0090:
            r0 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x00a0
            boolean r0 = r6.changed((float) r15)
            if (r0 == 0) goto L_0x009d
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x009f
        L_0x009d:
            r0 = 1024(0x400, float:1.435E-42)
        L_0x009f:
            r1 = r1 | r0
        L_0x00a0:
            r0 = r7 & 16
            if (r0 == 0) goto L_0x00a9
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r0 = r49
            goto L_0x00c1
        L_0x00a9:
            r0 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x00bf
            r0 = r49
            boolean r22 = r6.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x00ba
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00bc
        L_0x00ba:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x00bc:
            r1 = r1 | r22
            goto L_0x00c1
        L_0x00bf:
            r0 = r49
        L_0x00c1:
            r22 = r7 & 32
            if (r22 == 0) goto L_0x00cc
            r22 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r22
            r5 = r50
            goto L_0x00e4
        L_0x00cc:
            r22 = 458752(0x70000, float:6.42848E-40)
            r22 = r9 & r22
            if (r22 != 0) goto L_0x00e2
            r5 = r50
            boolean r22 = r6.changed((java.lang.Object) r5)
            if (r22 == 0) goto L_0x00dd
            r22 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00df
        L_0x00dd:
            r22 = 65536(0x10000, float:9.18355E-41)
        L_0x00df:
            r1 = r1 | r22
            goto L_0x00e4
        L_0x00e2:
            r5 = r50
        L_0x00e4:
            r22 = r7 & 64
            if (r22 == 0) goto L_0x00ef
            r22 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r22
            r5 = r51
            goto L_0x0107
        L_0x00ef:
            r22 = 3670016(0x380000, float:5.142788E-39)
            r22 = r9 & r22
            if (r22 != 0) goto L_0x0105
            r5 = r51
            boolean r22 = r6.changed((java.lang.Object) r5)
            if (r22 == 0) goto L_0x0100
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0102
        L_0x0100:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x0102:
            r1 = r1 | r22
            goto L_0x0107
        L_0x0105:
            r5 = r51
        L_0x0107:
            r0 = r7 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x010f
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x010d:
            r1 = r1 | r0
            goto L_0x0120
        L_0x010f:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x0120
            boolean r0 = r6.changed((java.lang.Object) r14)
            if (r0 == 0) goto L_0x011d
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010d
        L_0x011d:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x010d
        L_0x0120:
            r0 = r7 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x012a
            r0 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r0
            r0 = r53
            goto L_0x0141
        L_0x012a:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x013f
            r0 = r53
            boolean r22 = r6.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x013a
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x013c
        L_0x013a:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x013c:
            r1 = r1 | r22
            goto L_0x0141
        L_0x013f:
            r0 = r53
        L_0x0141:
            r0 = r7 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0149
            r0 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0147:
            r1 = r1 | r0
            goto L_0x015a
        L_0x0149:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x015a
            boolean r0 = r6.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x0157
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0147
        L_0x0157:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0147
        L_0x015a:
            r0 = r7 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0161
            r2 = r2 | 6
            goto L_0x0172
        L_0x0161:
            r0 = r8 & 14
            if (r0 != 0) goto L_0x0172
            boolean r0 = r6.changed((float) r12)
            if (r0 == 0) goto L_0x016e
            r19 = 4
            goto L_0x0170
        L_0x016e:
            r19 = 2
        L_0x0170:
            r2 = r2 | r19
        L_0x0172:
            r0 = r7 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0179
            r2 = r2 | 48
            goto L_0x0188
        L_0x0179:
            r0 = r8 & 112(0x70, float:1.57E-43)
            if (r0 != 0) goto L_0x0188
            boolean r0 = r6.changed((float) r11)
            if (r0 == 0) goto L_0x0184
            goto L_0x0186
        L_0x0184:
            r17 = r18
        L_0x0186:
            r2 = r2 | r17
        L_0x0188:
            r0 = r7 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x018f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x019e
        L_0x018f:
            r0 = r8 & 896(0x380, float:1.256E-42)
            if (r0 != 0) goto L_0x019e
            boolean r0 = r6.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x019a
            goto L_0x019c
        L_0x019a:
            r20 = r21
        L_0x019c:
            r2 = r2 | r20
        L_0x019e:
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r0 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x01bd
            r0 = r2 & 731(0x2db, float:1.024E-42)
            r4 = 146(0x92, float:2.05E-43)
            if (r0 != r4) goto L_0x01bd
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x01b4
            goto L_0x01bd
        L_0x01b4:
            r6.skipToGroupEnd()
            r17 = r45
            r38 = r2
            goto L_0x0413
        L_0x01bd:
            if (r3 == 0) goto L_0x01c4
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01c6
        L_0x01c4:
            r0 = r45
        L_0x01c6:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01d4
            java.lang.String r3 = "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1084)"
            r4 = 210227552(0xc87d160, float:2.0926056E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x01d4:
            int r3 = androidx.compose.ui.unit.Dp.m5985compareTo0680j_4(r55, r56)
            if (r3 <= 0) goto L_0x0459
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            kotlin.jvm.internal.Ref$IntRef r16 = new kotlin.jvm.internal.Ref$IntRef
            r16.<init>()
            r45 = r16
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r5 = r16
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r16 = 0
            r17 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r8)
            java.lang.Object r7 = r6.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r5 = r7
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            r7 = 0
            float r8 = r5.m5967toPx0680j_4(r11)
            r3.element = r8
            float r8 = r5.m5967toPx0680j_4(r12)
            r4.element = r8
            int r8 = r5.m5961roundToPx0680j_4(r15)
            r58 = r5
            r5 = r45
            r5.element = r8
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            float r7 = r3.element
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            float r8 = r4.element
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            int r16 = r2 >> 6
            r16 = r16 & 14
            r17 = 0
            r9 = 1618982084(0x607fb4c4, float:7.370227E19)
            r6.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r9)
            boolean r9 = r6.changed((java.lang.Object) r10)
            boolean r18 = r6.changed((java.lang.Object) r7)
            r9 = r9 | r18
            boolean r18 = r6.changed((java.lang.Object) r8)
            r9 = r9 | r18
            r45 = r6
            r18 = 0
            r58 = r7
            java.lang.Object r7 = r45.rememberedValue()
            r19 = 0
            if (r9 != 0) goto L_0x026f
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r8
            java.lang.Object r8 = r20.getEmpty()
            if (r7 != r8) goto L_0x026a
            goto L_0x0271
        L_0x026a:
            r8 = r45
            r20 = r7
            goto L_0x0281
        L_0x026f:
            r21 = r8
        L_0x0271:
            r8 = 0
            r20 = r7
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1 r7 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1
            r7.<init>(r10, r3, r4)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r8 = r45
            r8.updateRememberedValue(r7)
        L_0x0281:
            r6.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r8 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r7, r6, r8)
            if (r10 == 0) goto L_0x0299
            androidx.compose.material3.TopAppBarState r7 = r57.getState()
            if (r7 == 0) goto L_0x0299
            float r7 = r7.getCollapsedFraction()
            goto L_0x029a
        L_0x0299:
            r7 = 0
        L_0x029a:
            int r9 = r1 >> 24
            r9 = r9 & 112(0x70, float:1.57E-43)
            long r16 = r13.m2244containerColorXeAY9LY$material3_release(r7, r6, r9)
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m3154boximpl(r16)
            androidx.compose.runtime.State r9 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r9, r6, r8)
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1 r8 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
            r8.<init>(r14, r1)
            r11 = -1048401111(0xffffffffc182ab29, float:-16.333574)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r6, r11, r12, r8)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.animation.core.CubicBezierEasing r11 = TopTitleAlphaEasing
            float r11 = r11.transform(r7)
            r16 = 1065353216(0x3f800000, float:1.0)
            float r35 = r16 - r7
            r16 = 1056964608(0x3f000000, float:0.5)
            int r16 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r16 >= 0) goto L_0x02cc
            r16 = r12
            goto L_0x02ce
        L_0x02cc:
            r16 = 0
        L_0x02ce:
            r36 = r16
            if (r36 != 0) goto L_0x02d5
            r33 = r12
            goto L_0x02d7
        L_0x02d5:
            r33 = 0
        L_0x02d7:
            r12 = -1609667638(0xffffffffa00e6bca, float:-1.2063532E-19)
            r6.startReplaceableGroup(r12)
            java.lang.String r12 = "1148@51936L118,1148@51913L141,1151@52084L255"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r12)
            if (r10 == 0) goto L_0x03a2
            boolean r12 = r57.isPinned()
            if (r12 != 0) goto L_0x03a2
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r18 = androidx.compose.foundation.gestures.Orientation.Vertical
            int r16 = r2 >> 6
            r16 = r16 & 14
            r17 = 0
            r37 = r7
            r7 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            boolean r20 = r6.changed((java.lang.Object) r10)
            r21 = r6
            r22 = 0
            java.lang.Object r13 = r21.rememberedValue()
            r23 = 0
            if (r20 != 0) goto L_0x0320
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r24.getEmpty()
            if (r13 != r14) goto L_0x031b
            goto L_0x0320
        L_0x031b:
            r24 = r13
            r14 = r21
            goto L_0x0330
        L_0x0320:
            r14 = 0
            r24 = r13
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1 r13 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1
            r13.<init>(r10)
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r14 = r21
            r14.updateRememberedValue(r13)
        L_0x0330:
            r6.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r14 = 0
            androidx.compose.foundation.gestures.DraggableState r17 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r13, r6, r14)
            r16 = r12
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            r20 = 0
            r21 = 0
            r22 = 0
            int r13 = r2 >> 6
            r13 = r13 & 14
            r13 = r13 | 64
            r14 = 0
            r12 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            boolean r7 = r6.changed((java.lang.Object) r10)
            r12 = r6
            r19 = 0
            r38 = r2
            java.lang.Object r2 = r12.rememberedValue()
            r23 = 0
            if (r7 != 0) goto L_0x0378
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r7
            java.lang.Object r7 = r24.getEmpty()
            if (r2 != r7) goto L_0x0375
            goto L_0x037a
        L_0x0375:
            r24 = r2
            goto L_0x038b
        L_0x0378:
            r25 = r7
        L_0x037a:
            r7 = 0
            r24 = r2
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 r2 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1
            r26 = r7
            r7 = 0
            r2.<init>(r10, r7)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r12.updateRememberedValue(r2)
        L_0x038b:
            r6.endReplaceableGroup()
            r23 = r2
            kotlin.jvm.functions.Function3 r23 = (kotlin.jvm.functions.Function3) r23
            r24 = 0
            r25 = 188(0xbc, float:2.63E-43)
            r26 = 0
            r2 = 0
            r19 = r2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x03aa
        L_0x03a2:
            r38 = r2
            r37 = r7
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
        L_0x03aa:
            r6.endReplaceableGroup()
            androidx.compose.ui.Modifier r7 = r0.then(r2)
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3 r13 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3
            r16 = r13
            r17 = r53
            r18 = r3
            r19 = r54
            r20 = r49
            r21 = r50
            r22 = r11
            r23 = r36
            r24 = r51
            r25 = r8
            r26 = r1
            r27 = r4
            r28 = r57
            r29 = r46
            r30 = r47
            r31 = r35
            r32 = r5
            r34 = r9
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            r14 = 1985938853(0x765f05a5, float:1.1308561E33)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r6, r14, r12, r13)
            r25 = r12
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r28 = 126(0x7e, float:1.77E-43)
            r16 = r7
            r7 = 0
            r17 = r7
            r12 = 0
            r18 = r12
            r20 = r39
            r22 = r41
            r23 = r42
            r24 = r43
            r26 = r6
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27, r28)
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0411
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0411:
            r17 = r0
        L_0x0413:
            androidx.compose.runtime.ScopeUpdateScope r14 = r6.endRestartGroup()
            if (r14 != 0) goto L_0x0420
            r19 = r1
            r21 = r6
            r20 = r38
            goto L_0x0458
        L_0x0420:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4 r18 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4
            r0 = r18
            r19 = r1
            r1 = r17
            r20 = r38
            r2 = r46
            r3 = r47
            r4 = r48
            r5 = r49
            r21 = r6
            r6 = r50
            r7 = r51
            r8 = r52
            r9 = r53
            r10 = r54
            r11 = r55
            r12 = r56
            r13 = r57
            r44 = r14
            r14 = r59
            r15 = r60
            r16 = r61
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r44
            r1.updateScope(r0)
        L_0x0458:
            return
        L_0x0459:
            r19 = r1
            r20 = r2
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "A TwoRowsTopAppBar max height should be greater than its pinned height"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1746TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, float, float, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TwoRowsTopAppBar_tjU4iQQ$lambda-8  reason: not valid java name */
    public static final long m1747TwoRowsTopAppBar_tjU4iQQ$lambda8(State<Color> $appBarContainerColor$delegate) {
        return ((Color) $appBarContainerColor$delegate.getValue()).m3174unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: TopAppBarLayout-kXwM9vE  reason: not valid java name */
    public static final void m1745TopAppBarLayoutkXwM9vE(Modifier modifier, float heightPx, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Function2<? super Composer, ? super Integer, Unit> title, TextStyle titleTextStyle, float titleAlpha, Arrangement.Vertical titleVerticalArrangement, Arrangement.Horizontal titleHorizontalArrangement, int titleBottomPadding, boolean hideTitleSemantics, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function2<? super Composer, ? super Integer, Unit> actions, Composer $composer, int $changed, int $changed1) {
        int $dirty;
        Composer $composer2;
        float f = heightPx;
        TextStyle textStyle = titleTextStyle;
        Arrangement.Vertical vertical = titleVerticalArrangement;
        Arrangement.Horizontal horizontal = titleHorizontalArrangement;
        int i = titleBottomPadding;
        boolean z = hideTitleSemantics;
        Function2<? super Composer, ? super Integer, Unit> function2 = navigationIcon;
        Function2<? super Composer, ? super Integer, Unit> function22 = actions;
        int i2 = $changed;
        int i3 = $changed1;
        Composer $composer3 = $composer.startRestartGroup(-6794037);
        ComposerKt.sourceInformation($composer3, "C(TopAppBarLayout)P(4,2,6:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,3,5)1254@56484L4278:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i2 & 14) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 4 : 2;
        } else {
            Modifier modifier2 = modifier;
        }
        if ((i2 & 112) == 0) {
            $dirty2 |= $composer3.changed(f) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            $dirty = $dirty2 | ($composer3.changed(navigationIconContentColor) ? 256 : 128);
        } else {
            $dirty = $dirty2;
            long j = navigationIconContentColor;
        }
        if ((i2 & 7168) == 0) {
            $dirty |= $composer3.changed(titleContentColor) ? 2048 : 1024;
        } else {
            long j2 = titleContentColor;
        }
        if ((i2 & 57344) == 0) {
            $dirty |= $composer3.changed(actionIconContentColor) ? 16384 : 8192;
        } else {
            long j3 = actionIconContentColor;
        }
        if ((i2 & 458752) == 0) {
            $dirty |= $composer3.changed((Object) title) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = title;
        }
        if ((3670016 & i2) == 0) {
            $dirty |= $composer3.changed((Object) textStyle) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            $dirty |= $composer3.changed(titleAlpha) ? 8388608 : 4194304;
        } else {
            float f2 = titleAlpha;
        }
        if ((i2 & 234881024) == 0) {
            $dirty |= $composer3.changed((Object) vertical) ? 67108864 : 33554432;
        }
        if ((i2 & 1879048192) == 0) {
            $dirty |= $composer3.changed((Object) horizontal) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty;
        if ((i3 & 14) == 0) {
            $dirty1 |= $composer3.changed(i) ? 4 : 2;
        }
        if ((i3 & 112) == 0) {
            $dirty1 |= $composer3.changed(z) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            $dirty1 |= $composer3.changed((Object) function2) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            $dirty1 |= $composer3.changed((Object) function22) ? 2048 : 1024;
        }
        if ((1533916891 & $dirty3) == 306783378 && ($dirty1 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            Function2<? super Composer, ? super Integer, Unit> function24 = function22;
            int i4 = $dirty3;
            TextStyle textStyle2 = textStyle;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6794037, $dirty3, $dirty1, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:1238)");
            }
            MeasurePolicy measurePolicy$iv = new AppBarKt$TopAppBarLayout$2(f, horizontal, vertical, i);
            int $changed$iv = ($dirty3 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
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
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i5 = $changed$iv;
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            function3.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int $changed2 = ($changed$iv$iv >> 9) & 14;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            Composer $composer4 = $composer3;
            $composer4.startReplaceableGroup(1688650562);
            ComposerKt.sourceInformation($composer4, "C1256@56514L352,1266@56879L547,1279@57439L336:AppBar.kt#uh7d8r");
            Density density = density$iv;
            if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "navigationIcon");
                float f3 = TopAppBarHorizontalPadding;
                Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(layoutId, f3, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                LayoutDirection layoutDirection = layoutDirection$iv;
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                ViewConfiguration viewConfiguration = viewConfiguration$iv;
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                int i6 = $changed2;
                int i7 = $changed$iv$iv;
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                Alignment alignment = contentAlignment$iv;
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv = (Density) consume4;
                $composer2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv);
                Modifier modifier3 = modifier$iv;
                int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf2;
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
                LayoutDirection layoutDirection2 = layoutDirection$iv$iv;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
                function34.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                $composer4.startReplaceableGroup(2058660585);
                Composer $composer$iv = $composer4;
                int i8 = $changed$iv$iv$iv;
                $composer$iv.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                    int $changed3 = ((6 >> 6) & 112) | 6;
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    Density density2 = density$iv$iv;
                    Composer $composer5 = $composer$iv;
                    $composer5.startReplaceableGroup(1034743112);
                    ComposerKt.sourceInformation($composer5, "C1261@56689L163:AppBar.kt#uh7d8r");
                    int i9 = $changed3;
                    if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                        MeasurePolicy measurePolicy2 = measurePolicy$iv2;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(navigationIconContentColor))}, function2, $composer5, (($dirty1 >> 3) & 112) | 8);
                    } else {
                        $composer5.skipToGroupEnd();
                        MeasurePolicy measurePolicy3 = measurePolicy$iv2;
                    }
                    $composer5.endReplaceableGroup();
                } else {
                    $composer$iv.skipToGroupEnd();
                    Density density3 = density$iv$iv;
                    MeasurePolicy measurePolicy4 = measurePolicy$iv2;
                }
                $composer$iv.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                Modifier r6 = PaddingKt.m762paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "title"), f3, 0.0f, 2, (Object) null);
                Modifier modifier4 = Modifier.Companion;
                if (z) {
                    modifier4 = SemanticsModifierKt.clearAndSetSemantics(modifier4, AppBarKt$TopAppBarLayout$1$2.INSTANCE);
                }
                Modifier modifier$iv2 = r6.then(modifier4);
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                Alignment alignment2 = contentAlignment$iv2;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier5 = modifier$iv2;
                int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = materializerOf3;
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
                Density density4 = density$iv$iv2;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function37 = function36;
                function37.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer4.startReplaceableGroup(2058660585);
                Composer $composer$iv2 = $composer4;
                int i10 = $changed$iv$iv$iv2;
                $composer$iv2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function38 = function37;
                if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                    int $changed4 = ((0 >> 6) & 112) | 6;
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    Composer $composer6 = $composer$iv2;
                    $composer6.startReplaceableGroup(-280006401);
                    ComposerKt.sourceInformation($composer6, "C1272@57149L263:AppBar.kt#uh7d8r");
                    int i11 = $changed4;
                    if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                        LayoutDirection layoutDirection3 = layoutDirection$iv$iv2;
                        TextKt.ProvideTextStyle(titleTextStyle, ComposableLambdaKt.composableLambda($composer6, 824316656, true, new AppBarKt$TopAppBarLayout$1$3$1(titleContentColor, titleAlpha, title, $dirty3)), $composer6, (($dirty3 >> 18) & 14) | 48);
                    } else {
                        $composer6.skipToGroupEnd();
                        LayoutDirection layoutDirection4 = layoutDirection$iv$iv2;
                        TextStyle textStyle3 = titleTextStyle;
                    }
                    $composer6.endReplaceableGroup();
                } else {
                    $composer$iv2.skipToGroupEnd();
                    LayoutDirection layoutDirection5 = layoutDirection$iv$iv2;
                    TextStyle textStyle4 = titleTextStyle;
                }
                $composer$iv2.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                Modifier modifier$iv3 = PaddingKt.m764paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.Companion, "actionIcons"), 0.0f, 0.0f, f3, 0.0f, 11, (Object) null);
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                Alignment alignment3 = contentAlignment$iv3;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume10 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv3 = (Density) consume10;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume11 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume11;
                int i12 = $dirty3;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume12 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume12;
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv3);
                int $changed$iv$iv$iv3 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Modifier modifier6 = modifier$iv3;
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    $composer4.createNode(constructor4);
                } else {
                    $composer4.useNode();
                }
                $composer4.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2787constructorimpl($composer4);
                Function0<ComposeUiNode> function04 = constructor4;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer4.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
                $composer4.startReplaceableGroup(2058660585);
                int $changed$iv2 = ($changed$iv$iv$iv3 >> 9) & 14;
                Composer $composer$iv3 = $composer4;
                Density density5 = density$iv$iv3;
                $composer$iv3.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer$iv3, "C72@3384L9:Box.kt#2w3rfo");
                if (($changed$iv2 & 11) != 2 || !$composer$iv3.getSkipping()) {
                    int $changed5 = ((6 >> 6) & 112) | 6;
                    int i13 = $changed$iv2;
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    Composer $composer7 = $composer$iv3;
                    $composer7.startReplaceableGroup(1192272192);
                    ComposerKt.sourceInformation($composer7, "C1284@57609L152:AppBar.kt#uh7d8r");
                    int i14 = $changed5;
                    if (($changed5 & 81) != 16 || !$composer7.getSkipping()) {
                        ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(actionIconContentColor))}, actions, $composer7, (($dirty1 >> 6) & 112) | 8);
                    } else {
                        $composer7.skipToGroupEnd();
                        ViewConfiguration viewConfiguration4 = viewConfiguration$iv$iv3;
                        Function2<? super Composer, ? super Integer, Unit> function25 = actions;
                    }
                    $composer7.endReplaceableGroup();
                } else {
                    $composer$iv3.skipToGroupEnd();
                    int i15 = $changed$iv2;
                    ViewConfiguration viewConfiguration5 = viewConfiguration$iv$iv3;
                    Function2<? super Composer, ? super Integer, Unit> function26 = actions;
                }
                $composer$iv3.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
            } else {
                $composer4.skipToGroupEnd();
                LayoutDirection layoutDirection6 = layoutDirection$iv;
                $composer2 = $composer3;
                Function2<? super Composer, ? super Integer, Unit> function27 = function22;
                int i16 = $dirty3;
                ViewConfiguration viewConfiguration6 = viewConfiguration$iv;
                int i17 = $changed2;
                int i18 = $changed$iv$iv;
                TextStyle textStyle5 = textStyle;
            }
            $composer4.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i19 = $dirty1;
            Composer composer = $composer2;
            return;
        }
        int i20 = $dirty1;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new AppBarKt$TopAppBarLayout$3(modifier, heightPx, navigationIconContentColor, titleContentColor, actionIconContentColor, title, titleTextStyle, titleAlpha, titleVerticalArrangement, titleHorizontalArrangement, titleBottomPadding, hideTitleSemantics, navigationIcon, actions, $changed, $changed1));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d1, code lost:
        if (r3 == null) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d9, code lost:
        if (r13.getHeightOffset() >= 0.0f) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e5, code lost:
        if (r13.getHeightOffset() <= r13.getHeightOffsetLimit()) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e7, code lost:
        r1 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13.getHeightOffset(), 0.0f, 0, 0, false, 30, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0102, code lost:
        if (r13.getCollapsedFraction() >= 0.5f) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0104, code lost:
        r2 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0106, code lost:
        r2 = r13.getHeightOffsetLimit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010a, code lost:
        r0.L$0 = r12;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0128, code lost:
        if (androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r1, kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2), r3, false, new androidx.compose.material3.AppBarKt$settleAppBar$3(r13), r0, 4, (java.lang.Object) null) != r10) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x012a, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x012b, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x012c, code lost:
        r12 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0137, code lost:
        return androidx.compose.ui.unit.Velocity.m6202boximpl(androidx.compose.ui.unit.VelocityKt.Velocity(0.0f, r12.element));
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object settleAppBar(androidx.compose.material3.TopAppBarState r23, float r24, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r25, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r26, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r27) {
        /*
            r0 = r27
            boolean r1 = r0 instanceof androidx.compose.material3.AppBarKt$settleAppBar$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.material3.AppBarKt$settleAppBar$1 r1 = (androidx.compose.material3.AppBarKt$settleAppBar$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.material3.AppBarKt$settleAppBar$1 r1 = new androidx.compose.material3.AppBarKt$settleAppBar$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r9 = r0.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r11 = 0
            switch(r1) {
                case 0: goto L_0x004a;
                case 1: goto L_0x0039;
                case 2: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            java.lang.Object r1 = r0.L$0
            kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x012c
        L_0x0039:
            java.lang.Object r1 = r0.L$2
            kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
            java.lang.Object r2 = r0.L$1
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            java.lang.Object r3 = r0.L$0
            androidx.compose.material3.TopAppBarState r3 = (androidx.compose.material3.TopAppBarState) r3
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00c4
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r9)
            r8 = r23
            r12 = r25
            r14 = r24
            r7 = r26
            float r1 = r8.getCollapsedFraction()
            r2 = 1008981770(0x3c23d70a, float:0.01)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0138
            float r1 = r8.getCollapsedFraction()
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            if (r1 != 0) goto L_0x006d
            r1 = r3
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            if (r1 == 0) goto L_0x0072
            goto L_0x013a
        L_0x0072:
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r6 = r1
            r6.element = r14
            if (r12 == 0) goto L_0x00c8
            float r1 = java.lang.Math.abs(r14)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c8
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r5 = r1
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 28
            r21 = 0
            androidx.compose.animation.core.AnimationState r1 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)
            r4 = 0
            androidx.compose.material3.AppBarKt$settleAppBar$2 r2 = new androidx.compose.material3.AppBarKt$settleAppBar$2
            r2.<init>(r5, r8, r6)
            r13 = r2
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r14 = 2
            r15 = 0
            r0.L$0 = r8
            r0.L$1 = r7
            r0.L$2 = r6
            r0.label = r3
            r2 = r12
            r3 = r4
            r4 = r13
            r13 = r5
            r5 = r0
            r16 = r6
            r6 = r14
            r17 = r7
            r7 = r15
            java.lang.Object r1 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r1, r2, r3, r4, r5, r6, r7)
            if (r1 != r10) goto L_0x00bf
            return r10
        L_0x00bf:
            r3 = r8
            r1 = r16
            r2 = r17
        L_0x00c4:
            r12 = r1
            r13 = r3
            r3 = r2
            goto L_0x00d1
        L_0x00c8:
            r16 = r6
            r17 = r7
            r13 = r8
            r12 = r16
            r3 = r17
        L_0x00d1:
            if (r3 == 0) goto L_0x012d
            float r1 = r13.getHeightOffset()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x012d
            float r1 = r13.getHeightOffset()
            float r2 = r13.getHeightOffsetLimit()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x012d
            float r14 = r13.getHeightOffset()
            r15 = 0
            r16 = 0
            r18 = 0
            r20 = 0
            r21 = 30
            r22 = 0
            androidx.compose.animation.core.AnimationState r1 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r14, r15, r16, r18, r20, r21, r22)
            float r2 = r13.getCollapsedFraction()
            r4 = 1056964608(0x3f000000, float:0.5)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0106
            r2 = r11
            goto L_0x010a
        L_0x0106:
            float r2 = r13.getHeightOffsetLimit()
        L_0x010a:
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r4 = 0
            androidx.compose.material3.AppBarKt$settleAppBar$3 r5 = new androidx.compose.material3.AppBarKt$settleAppBar$3
            r5.<init>(r13)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r7 = 4
            r8 = 0
            r0.L$0 = r12
            r6 = 0
            r0.L$1 = r6
            r0.L$2 = r6
            r6 = 2
            r0.label = r6
            r6 = r0
            java.lang.Object r1 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 != r10) goto L_0x012b
            return r10
        L_0x012b:
            r1 = r12
        L_0x012c:
            r12 = r1
        L_0x012d:
            float r1 = r12.element
            long r1 = androidx.compose.ui.unit.VelocityKt.Velocity(r11, r1)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6202boximpl(r1)
            return r1
        L_0x0138:
            r17 = r7
        L_0x013a:
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m6222getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6202boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBar(androidx.compose.material3.TopAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }
}
