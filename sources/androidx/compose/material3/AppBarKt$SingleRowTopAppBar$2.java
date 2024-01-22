package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$SingleRowTopAppBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $actionsRow;
    final /* synthetic */ boolean $centeredTitle;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$SingleRowTopAppBar$2(WindowInsets windowInsets, TopAppBarColors topAppBarColors, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, TopAppBarScrollBehavior topAppBarScrollBehavior) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$colors = topAppBarColors;
        this.$title = function2;
        this.$titleTextStyle = textStyle;
        this.$centeredTitle = z;
        this.$navigationIcon = function22;
        this.$actionsRow = function23;
        this.$$dirty = i;
        this.$scrollBehavior = topAppBarScrollBehavior;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        float f;
        TopAppBarState state;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C*1048@47801L7,1052@47951L890:AppBar.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(376925230, i, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1047)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            TopAppBarScrollBehavior topAppBarScrollBehavior = this.$scrollBehavior;
            float r4 = ((Density) consume).m5967toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m2712getContainerHeightD9Ej5fM());
            if (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) {
                f = 0.0f;
            } else {
                f = state.getHeightOffset();
            }
            float height = r4 + f;
            Modifier clipToBounds = ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, this.$windowInsets));
            long r3 = this.$colors.m2246getNavigationIconContentColor0d7_KjU$material3_release();
            long r5 = this.$colors.m2247getTitleContentColor0d7_KjU$material3_release();
            long r7 = this.$colors.m2245getActionIconContentColor0d7_KjU$material3_release();
            Function2<Composer, Integer, Unit> function2 = this.$title;
            TextStyle textStyle = this.$titleTextStyle;
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Arrangement.Horizontal center2 = this.$centeredTitle ? Arrangement.INSTANCE.getCenter() : Arrangement.INSTANCE.getStart();
            Function2<Composer, Integer, Unit> function22 = this.$navigationIcon;
            Function2<Composer, Integer, Unit> function23 = this.$actionsRow;
            int i2 = this.$$dirty;
            AppBarKt.m1745TopAppBarLayoutkXwM9vE(clipToBounds, height, r3, r5, r7, function2, textStyle, 1.0f, center, center2, 0, false, function22, function23, $composer, ((i2 << 12) & 458752) | 113246208 | ((i2 << 12) & 3670016), ((i2 >> 6) & 896) | 3126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
