package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000_\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0003\b\u000b\u001d\u001a\u0017\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\b\u001a!\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010(\u001a\u0015\u0010)\u001a\u00020 *\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010*\u001a\u0015\u0010+\u001a\u00020 *\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010*\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\t\"\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\f\"\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"O\u0010\u0012\u001a=\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\u0002\b\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"DEBUG", "", "DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", "F", "EmptyInteractionSources", "androidx/compose/foundation/pager/PagerStateKt$EmptyInteractionSources$1", "Landroidx/compose/foundation/pager/PagerStateKt$EmptyInteractionSources$1;", "EmptyLayoutInfo", "androidx/compose/foundation/pager/PagerStateKt$EmptyLayoutInfo$1", "Landroidx/compose/foundation/pager/PagerStateKt$EmptyLayoutInfo$1;", "MaxPageOffset", "", "MaxPagesForAnimateScroll", "", "MinPageOffset", "SnapAlignmentStartToStart", "Lkotlin/Function3;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", "name", "layoutSize", "itemSize", "Lkotlin/ExtensionFunctionType;", "getSnapAlignmentStartToStart", "()Lkotlin/jvm/functions/Function3;", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "rememberPagerState", "Landroidx/compose/foundation/pager/PagerState;", "initialPage", "initialPageOffsetFraction", "(IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
public final class PagerStateKt {
    private static final boolean DEBUG = false;
    private static final float DefaultPositionThreshold = Dp.m5986constructorimpl((float) 56);
    /* access modifiers changed from: private */
    public static final PagerStateKt$EmptyInteractionSources$1 EmptyInteractionSources = new PagerStateKt$EmptyInteractionSources$1();
    /* access modifiers changed from: private */
    public static final PagerStateKt$EmptyLayoutInfo$1 EmptyLayoutInfo = new PagerStateKt$EmptyLayoutInfo$1();
    private static final float MaxPageOffset = 0.5f;
    private static final int MaxPagesForAnimateScroll = 3;
    private static final float MinPageOffset = -0.5f;
    private static final Function3<Density, Float, Float, Float> SnapAlignmentStartToStart = PagerStateKt$SnapAlignmentStartToStart$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final PagerStateKt$UnitDensity$1 UnitDensity = new PagerStateKt$UnitDensity$1();

    public static final PagerState rememberPagerState(int initialPage, float initialPageOffsetFraction, Composer $composer, int $changed, int i) {
        float initialPageOffsetFraction2;
        Object value$iv$iv;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(144687223);
        ComposerKt.sourceInformation(composer, "C(rememberPagerState)70@2945L108,70@2902L151:PagerState.kt#g6yjnt");
        int initialPage2 = (i & 1) != 0 ? 0 : initialPage;
        if ((i & 2) != 0) {
            initialPageOffsetFraction2 = 0.0f;
        } else {
            initialPageOffsetFraction2 = initialPageOffsetFraction;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(144687223, i2, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:66)");
        }
        Object[] objArr = new Object[0];
        Saver saver = PagerState.Companion.getSaver();
        Object key1$iv = Integer.valueOf(initialPage2);
        Object key2$iv = Float.valueOf(initialPageOffsetFraction2);
        int i3 = (i2 & 14) | (i2 & 112);
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed(key1$iv) | composer.changed(key2$iv);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function0) new PagerStateKt$rememberPagerState$1$1(initialPage2, initialPageOffsetFraction2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        PagerState pagerState = (PagerState) RememberSaveableKt.rememberSaveable(objArr, saver, (String) null, value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return pagerState;
    }

    public static final Object animateToNextPage(PagerState $this$animateToNextPage, Continuation<? super Unit> $completion) {
        if ($this$animateToNextPage.getCurrentPage() + 1 >= $this$animateToNextPage.getPageCount$foundation_release()) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default($this$animateToNextPage, $this$animateToNextPage.getCurrentPage() + 1, 0.0f, (AnimationSpec) null, $completion, 6, (Object) null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    public static final Object animateToPreviousPage(PagerState $this$animateToPreviousPage, Continuation<? super Unit> $completion) {
        if ($this$animateToPreviousPage.getCurrentPage() - 1 < 0) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default($this$animateToPreviousPage, $this$animateToPreviousPage.getCurrentPage() - 1, 0.0f, (AnimationSpec) null, $completion, 6, (Object) null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    public static final Function3<Density, Float, Float, Float> getSnapAlignmentStartToStart() {
        return SnapAlignmentStartToStart;
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    private static final void debugLog(Function0<String> generateMsg) {
    }
}
