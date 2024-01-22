package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallCenteredTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010JK\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001dJK\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001dJG\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0010JG\u0010!\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u0010J'\u0010#\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0002\u0010$JG\u0010%\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", "", "()V", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "centerAlignedTopAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "centerAlignedTopAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "enterAlwaysScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "smallTopAppBarColors", "smallTopAppBarColors-zjMxDiM", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: AppBar.kt */
public final class TopAppBarDefaults {
    public static final int $stable = 0;
    public static final TopAppBarDefaults INSTANCE = new TopAppBarDefaults();

    private TopAppBarDefaults() {
    }

    /* renamed from: smallTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2251smallTopAppBarColorszjMxDiM(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Composer $composer, int $changed, int i) {
        long scrolledContainerColor2;
        long navigationIconContentColor2;
        long titleContentColor2;
        long actionIconContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-1717201472);
        ComposerKt.sourceInformation(composer, "C(smallTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)546@26281L9,547@26346L11,551@26590L9,552@26671L9,553@26761L9:AppBar.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getContainerColor(), composer, 6) : containerColor;
        if ((i & 2) != 0) {
            scrolledContainerColor2 = ColorSchemeKt.m1852applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer, 6), containerColor2, TopAppBarSmallTokens.INSTANCE.m2714getOnScrollContainerElevationD9Ej5fM());
        } else {
            scrolledContainerColor2 = scrolledContainerColor;
        }
        if ((i & 4) != 0) {
            navigationIconContentColor2 = ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getLeadingIconColor(), composer, 6);
        } else {
            navigationIconContentColor2 = navigationIconContentColor;
        }
        if ((i & 8) != 0) {
            titleContentColor2 = ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getHeadlineColor(), composer, 6);
        } else {
            titleContentColor2 = titleContentColor;
        }
        if ((i & 16) != 0) {
            actionIconContentColor2 = ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getTrailingIconColor(), composer, 6);
        } else {
            actionIconContentColor2 = actionIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1717201472, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.smallTopAppBarColors (AppBar.kt:545)");
        } else {
            int i2 = $changed;
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(containerColor2, scrolledContainerColor2, navigationIconContentColor2, titleContentColor2, actionIconContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return topAppBarColors;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(2143182847);
        ComposerKt.sourceInformation($composer, "C568@27169L29:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143182847, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:568)");
        }
        WindowInsets r0 = WindowInsetsKt.m850onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, $composer, 8), WindowInsetsSides.m864plusgK_yJZ4(WindowInsetsSides.Companion.m874getHorizontalJoeWqyM(), WindowInsetsSides.Companion.m878getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: centerAlignedTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2248centerAlignedTopAppBarColorszjMxDiM(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Composer $composer, int $changed, int i) {
        long scrolledContainerColor2;
        long navigationIconContentColor2;
        long titleContentColor2;
        long actionIconContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(1896017784);
        ComposerKt.sourceInformation(composer, "C(centerAlignedTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)584@28054L9,585@28119L11,589@28371L9,590@28460L9,591@28558L9:AppBar.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getContainerColor(), composer, 6) : containerColor;
        if ((i & 2) != 0) {
            scrolledContainerColor2 = ColorSchemeKt.m1852applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer, 6), containerColor2, TopAppBarSmallTokens.INSTANCE.m2714getOnScrollContainerElevationD9Ej5fM());
        } else {
            scrolledContainerColor2 = scrolledContainerColor;
        }
        if ((i & 4) != 0) {
            navigationIconContentColor2 = ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getLeadingIconColor(), composer, 6);
        } else {
            navigationIconContentColor2 = navigationIconContentColor;
        }
        if ((i & 8) != 0) {
            titleContentColor2 = ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getHeadlineColor(), composer, 6);
        } else {
            titleContentColor2 = titleContentColor;
        }
        if ((i & 16) != 0) {
            actionIconContentColor2 = ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getTrailingIconColor(), composer, 6);
        } else {
            actionIconContentColor2 = actionIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896017784, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:583)");
        } else {
            int i2 = $changed;
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(containerColor2, scrolledContainerColor2, navigationIconContentColor2, titleContentColor2, actionIconContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return topAppBarColors;
    }

    /* renamed from: mediumTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2250mediumTopAppBarColorszjMxDiM(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Composer $composer, int $changed, int i) {
        long scrolledContainerColor2;
        long navigationIconContentColor2;
        long titleContentColor2;
        long actionIconContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-582474442);
        ComposerKt.sourceInformation(composer, "C(mediumTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)615@29598L9,616@29663L11,620@29908L9,621@29990L9,622@30081L9:AppBar.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getContainerColor(), composer, 6) : containerColor;
        if ((i & 2) != 0) {
            scrolledContainerColor2 = ColorSchemeKt.m1852applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer, 6), containerColor2, TopAppBarSmallTokens.INSTANCE.m2714getOnScrollContainerElevationD9Ej5fM());
        } else {
            scrolledContainerColor2 = scrolledContainerColor;
        }
        if ((i & 4) != 0) {
            navigationIconContentColor2 = ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getLeadingIconColor(), composer, 6);
        } else {
            navigationIconContentColor2 = navigationIconContentColor;
        }
        if ((i & 8) != 0) {
            titleContentColor2 = ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getHeadlineColor(), composer, 6);
        } else {
            titleContentColor2 = titleContentColor;
        }
        if ((i & 16) != 0) {
            actionIconContentColor2 = ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getTrailingIconColor(), composer, 6);
        } else {
            actionIconContentColor2 = actionIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-582474442, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:614)");
        } else {
            int i2 = $changed;
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(containerColor2, scrolledContainerColor2, navigationIconContentColor2, titleContentColor2, actionIconContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return topAppBarColors;
    }

    /* renamed from: largeTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2249largeTopAppBarColorszjMxDiM(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Composer $composer, int $changed, int i) {
        long scrolledContainerColor2;
        long navigationIconContentColor2;
        long titleContentColor2;
        long actionIconContentColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-1471507700);
        ComposerKt.sourceInformation(composer, "C(largeTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)646@31118L9,647@31183L11,651@31427L9,652@31508L9,653@31598L9:AppBar.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getContainerColor(), composer, 6) : containerColor;
        if ((i & 2) != 0) {
            scrolledContainerColor2 = ColorSchemeKt.m1852applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer, 6), containerColor2, TopAppBarSmallTokens.INSTANCE.m2714getOnScrollContainerElevationD9Ej5fM());
        } else {
            scrolledContainerColor2 = scrolledContainerColor;
        }
        if ((i & 4) != 0) {
            navigationIconContentColor2 = ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getLeadingIconColor(), composer, 6);
        } else {
            navigationIconContentColor2 = navigationIconContentColor;
        }
        if ((i & 8) != 0) {
            titleContentColor2 = ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getHeadlineColor(), composer, 6);
        } else {
            titleContentColor2 = titleContentColor;
        }
        if ((i & 16) != 0) {
            actionIconContentColor2 = ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getTrailingIconColor(), composer, 6);
        } else {
            actionIconContentColor2 = actionIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1471507700, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:645)");
        } else {
            int i2 = $changed;
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(containerColor2, scrolledContainerColor2, navigationIconContentColor2, titleContentColor2, actionIconContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return topAppBarColors;
    }

    @ExperimentalMaterial3Api
    public final TopAppBarScrollBehavior pinnedScrollBehavior(TopAppBarState state, Function0<Boolean> canScroll, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(286497075);
        ComposerKt.sourceInformation($composer, "C(pinnedScrollBehavior)P(1)675@32455L24:AppBar.kt#uh7d8r");
        if ((i & 1) != 0) {
            state = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer, 0, 7);
        }
        if ((i & 2) != 0) {
            canScroll = TopAppBarDefaults$pinnedScrollBehavior$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(286497075, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:674)");
        }
        PinnedScrollBehavior pinnedScrollBehavior = new PinnedScrollBehavior(state, canScroll);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return pinnedScrollBehavior;
    }

    @ExperimentalMaterial3Api
    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState state, Function0<Boolean> canScroll, AnimationSpec<Float> snapAnimationSpec, DecayAnimationSpec<Float> flingAnimationSpec, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(959086674);
        ComposerKt.sourceInformation($composer, "C(enterAlwaysScrollBehavior)P(3!1,2)697@33729L24,700@33955L26:AppBar.kt#uh7d8r");
        if ((i & 1) != 0) {
            state = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer, 0, 7);
        }
        if ((i & 2) != 0) {
            canScroll = TopAppBarDefaults$enterAlwaysScrollBehavior$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            snapAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 8) != 0) {
            flingAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(959086674, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:696)");
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = new EnterAlwaysScrollBehavior(state, snapAnimationSpec, flingAnimationSpec, canScroll);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return enterAlwaysScrollBehavior;
    }

    @ExperimentalMaterial3Api
    public final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(TopAppBarState state, Function0<Boolean> canScroll, AnimationSpec<Float> snapAnimationSpec, DecayAnimationSpec<Float> flingAnimationSpec, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-1757023234);
        ComposerKt.sourceInformation($composer, "C(exitUntilCollapsedScrollBehavior)P(3!1,2)730@35483L24,733@35709L26:AppBar.kt#uh7d8r");
        if ((i & 1) != 0) {
            state = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer, 0, 7);
        }
        if ((i & 2) != 0) {
            canScroll = TopAppBarDefaults$exitUntilCollapsedScrollBehavior$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            snapAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 8) != 0) {
            flingAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1757023234, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:729)");
        }
        ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior = new ExitUntilCollapsedScrollBehavior(state, snapAnimationSpec, flingAnimationSpec, canScroll);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return exitUntilCollapsedScrollBehavior;
    }
}
