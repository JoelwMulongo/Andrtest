package androidx.compose.material;

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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
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
        ComposerKt.sourceInformation(composer, "C245@11859L21,246@11910L24,247@11967L185,253@12161L2557:TabRow.kt#jmzs0o");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1455860572, i, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:244)");
            }
            ScrollState scrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            Composer composer$iv = $composer;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
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
            ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
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
                    return m1664invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
                }

                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final MeasureResult m1664invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
                    SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                    int minTabWidth = subcomposeMeasureScope.m5961roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                    int padding = subcomposeMeasureScope.m5961roundToPx0680j_4(f2);
                    long tabConstraints = Constraints.m5921copyZbe2FdA$default(constraints, minTabWidth, 0, 0, 0, 14, (Object) null);
                    Iterable<Measurable> $this$map$iv = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function23);
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Measurable it : $this$map$iv) {
                        destination$iv$iv.add(it.m4863measureBRTryo0(tabConstraints));
                    }
                    List<Placeable> tabPlaceables = (List) destination$iv$iv;
                    Ref.IntRef layoutWidth = new Ref.IntRef();
                    layoutWidth.element = padding * 2;
                    Ref.IntRef layoutHeight = new Ref.IntRef();
                    for (Placeable it2 : tabPlaceables) {
                        layoutWidth.element += it2.getWidth();
                        layoutHeight.element = Math.max(layoutHeight.element, it2.getHeight());
                    }
                    int i = layoutWidth.element;
                    int i2 = layoutHeight.element;
                    final Function2<Composer, Integer, Unit> function2 = function24;
                    final ScrollableTabData scrollableTabData = scrollableTabData;
                    final int i3 = i3;
                    final int i4 = padding;
                    final List list = tabPlaceables;
                    Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function3;
                    final SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
                    int i5 = i;
                    final long j = constraints;
                    Ref.IntRef layoutHeight2 = layoutHeight;
                    final Ref.IntRef layoutHeight3 = layoutWidth;
                    Ref.IntRef intRef = layoutWidth;
                    final Ref.IntRef layoutWidth2 = layoutHeight2;
                    long j2 = tabConstraints;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = function3;
                    final int i6 = i4;
                    return MeasureScope.layout$default(subcomposeMeasureScope, i5, i2, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((Placeable.PlacementScope) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Placeable.PlacementScope $this$layout) {
                            Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                            final List tabPositions = new ArrayList();
                            int left = i4;
                            SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                            int left2 = left;
                            for (Placeable it : list) {
                                Placeable.PlacementScope.placeRelative$default($this$layout, it, left2, 0, 0.0f, 4, (Object) null);
                                tabPositions.add(new TabPosition(subcomposeMeasureScope.m5964toDpu2uoSUM(left2), subcomposeMeasureScope.m5964toDpu2uoSUM(it.getWidth()), (DefaultConstructorMarker) null));
                                left2 += it.getWidth();
                            }
                            long j = j;
                            Ref.IntRef intRef = layoutHeight3;
                            Ref.IntRef intRef2 = layoutWidth2;
                            for (Measurable it2 : subcomposeMeasureScope2.subcompose(TabSlots.Divider, function2)) {
                                Placeable placeable = it2.m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(j, intRef.element, intRef.element, 0, 0, 8, (Object) null));
                                Measurable measurable = it2;
                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, intRef2.element - placeable.getHeight(), 0.0f, 4, (Object) null);
                                intRef2 = intRef2;
                            }
                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope2;
                            TabSlots tabSlots = TabSlots.Indicator;
                            final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function32;
                            final int i = i6;
                            Ref.IntRef intRef3 = layoutHeight3;
                            Ref.IntRef intRef4 = layoutWidth2;
                            for (Measurable it3 : subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(230769237, true, new Function2<Composer, Integer, Unit>() {
                                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                    invoke((Composer) p1, ((Number) p2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer, int $changed) {
                                    ComposerKt.sourceInformation($composer, "C301@14269L23:TabRow.kt#jmzs0o");
                                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(230769237, $changed, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:300)");
                                        }
                                        function3.invoke(tabPositions, $composer, Integer.valueOf(((i >> 12) & 112) | 8));
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
                                Placeable.PlacementScope.placeRelative$default($this$layout, it3.m4863measureBRTryo0(Constraints.Companion.m5938fixedJhjzzOo(intRef3.element, intRef4.element)), 0, 0, 0.0f, 4, (Object) null);
                            }
                            scrollableTabData.onLaidOut(subcomposeMeasureScope2, i4, tabPositions, i3);
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
