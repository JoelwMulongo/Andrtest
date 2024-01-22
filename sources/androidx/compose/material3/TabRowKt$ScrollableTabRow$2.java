package androidx.compose.material3;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$ScrollableTabRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$ScrollableTabRow$2(float f, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i2) {
        super(2);
        this.$edgePadding = f;
        this.$tabs = function2;
        this.$divider = function22;
        this.$selectedTabIndex = i;
        this.$indicator = function3;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Object value$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C242@11425L21,243@11476L24,244@11533L185,250@11727L2752:TabRow.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(286469328, i, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:241)");
            }
            ScrollState scrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            Composer composer$iv = $composer;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv$iv = $composer;
            Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
            if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
                $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
            $composer.endReplaceableGroup();
            CoroutineScope coroutineScope2 = coroutineScope;
            composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = composer.changed((Object) scrollState) | composer.changed((Object) coroutineScope2);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new ScrollableTabData(scrollState, coroutineScope2);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenterStart(), false, 2, (Object) null), scrollState, false, (FlingBehavior) null, false, 14, (Object) null)));
            float f = this.$edgePadding;
            Function2<Composer, Integer, Unit> function2 = this.$tabs;
            Function2<Composer, Integer, Unit> function22 = this.$divider;
            int i2 = this.$selectedTabIndex;
            final float f2 = f;
            final Function2<Composer, Integer, Unit> function23 = function2;
            final Function2<Composer, Integer, Unit> function24 = function22;
            final ScrollableTabData scrollableTabData = (ScrollableTabData) value$iv$iv;
            final int i3 = i2;
            final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
            final int i4 = this.$$dirty;
            SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return m2136invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
                }

                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final MeasureResult m2136invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
                    SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                    int minTabWidth = subcomposeMeasureScope.m5961roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                    int padding = subcomposeMeasureScope.m5961roundToPx0680j_4(f2);
                    List<Measurable> $this$fold$iv = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function23);
                    int accumulator$iv = 0;
                    for (Measurable measurable : $this$fold$iv) {
                        accumulator$iv = Math.max(accumulator$iv, measurable.maxIntrinsicHeight(Integer.MAX_VALUE));
                    }
                    long tabConstraints = Constraints.m5921copyZbe2FdA$default(constraints, minTabWidth, 0, accumulator$iv, 0, 10, (Object) null);
                    Iterable<Measurable> $this$map$iv = $this$fold$iv;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Measurable it : $this$map$iv) {
                        destination$iv$iv.add(it.m4863measureBRTryo0(tabConstraints));
                    }
                    List<Placeable> tabPlaceables = (List) destination$iv$iv;
                    final int accumulator$iv2 = padding * 2;
                    for (Placeable measurable2 : tabPlaceables) {
                        accumulator$iv2 += measurable2.getWidth();
                    }
                    final Function2<Composer, Integer, Unit> function2 = function24;
                    final ScrollableTabData scrollableTabData = scrollableTabData;
                    final int i = i3;
                    final int i2 = padding;
                    final List list = tabPlaceables;
                    final SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
                    final long j = constraints;
                    Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function3;
                    final int i3 = accumulator$iv;
                    long j2 = tabConstraints;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = function3;
                    final int i4 = i4;
                    return MeasureScope.layout$default(subcomposeMeasureScope, accumulator$iv2, accumulator$iv, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((Placeable.PlacementScope) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Placeable.PlacementScope $this$layout) {
                            Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                            final List tabPositions = new ArrayList();
                            int left = i2;
                            SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                            int left2 = left;
                            for (Placeable it : list) {
                                Placeable.PlacementScope.placeRelative$default($this$layout, it, left2, 0, 0.0f, 4, (Object) null);
                                tabPositions.add(new TabPosition(subcomposeMeasureScope.m5964toDpu2uoSUM(left2), subcomposeMeasureScope.m5964toDpu2uoSUM(it.getWidth()), (DefaultConstructorMarker) null));
                                left2 += it.getWidth();
                            }
                            long j = j;
                            int i = accumulator$iv2;
                            int i2 = i3;
                            for (Measurable it2 : subcomposeMeasureScope2.subcompose(TabSlots.Divider, function2)) {
                                Placeable placeable = it2.m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(j, i, i, 0, 0, 8, (Object) null));
                                Measurable measurable = it2;
                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, i2 - placeable.getHeight(), 0.0f, 4, (Object) null);
                                i2 = i2;
                            }
                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope2;
                            TabSlots tabSlots = TabSlots.Indicator;
                            final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function32;
                            final int i3 = i4;
                            int i4 = accumulator$iv2;
                            int i5 = i3;
                            for (Measurable it3 : subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(963343607, true, new Function2<Composer, Integer, Unit>() {
                                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                    invoke((Composer) p1, ((Number) p2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer, int $changed) {
                                    ComposerKt.sourceInformation($composer, "C302@14030L23:TabRow.kt#uh7d8r");
                                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(963343607, $changed, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:301)");
                                        }
                                        function3.invoke(tabPositions, $composer, Integer.valueOf(((i3 >> 12) & 112) | 8));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer.skipToGroupEnd();
                                }
                            }))) {
                                Measurable measurable2 = it3;
                                Placeable.PlacementScope.placeRelative$default($this$layout, it3.m4863measureBRTryo0(Constraints.Companion.m5938fixedJhjzzOo(i4, i5)), 0, 0, 0.0f, 4, (Object) null);
                            }
                            scrollableTabData.onLaidOut(subcomposeMeasureScope2, i2, tabPositions, i);
                        }
                    }, 4, (Object) null);
                }
            }, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
