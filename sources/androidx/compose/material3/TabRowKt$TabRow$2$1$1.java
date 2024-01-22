package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$TabRow$2$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$TabRow$2$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m2137invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m2137invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int tabRowWidth = Constraints.m5930getMaxWidthimpl(constraints);
        List<Measurable> $this$fold$iv = subcomposeMeasureScope.subcompose(TabSlots.Tabs, this.$tabs);
        int tabCount = $this$fold$iv.size();
        int tabWidth = tabRowWidth / tabCount;
        int accumulator$iv = 0;
        for (Measurable curr : $this$fold$iv) {
            accumulator$iv = Math.max(curr.maxIntrinsicHeight(tabWidth), accumulator$iv);
        }
        Iterable<Measurable> $this$map$iv = $this$fold$iv;
        int $i$f$map = false;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Measurable it : $this$map$iv) {
            destination$iv$iv.add(it.m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, tabWidth, tabWidth, accumulator$iv, 0, 8, (Object) null)));
            $this$map$iv = $this$map$iv;
            $i$f$map = $i$f$map;
        }
        int i = $i$f$map;
        final List tabPlaceables = (List) destination$iv$iv;
        ArrayList tabPositions = new ArrayList(tabCount);
        for (int index = 0; index < tabCount; index++) {
            tabPositions.add(new TabPosition(Dp.m5986constructorimpl(((float) index) * subcomposeMeasureScope.m5964toDpu2uoSUM(tabWidth)), subcomposeMeasureScope.m5964toDpu2uoSUM(tabWidth), (DefaultConstructorMarker) null));
        }
        final Function2<Composer, Integer, Unit> function2 = this.$divider;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        final SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
        final int i2 = tabWidth;
        final long j = constraints;
        final int i3 = accumulator$iv;
        final List list = tabPositions;
        int i4 = tabWidth;
        final int tabWidth2 = this.$$dirty;
        int i5 = tabCount;
        final int tabCount2 = tabRowWidth;
        return MeasureScope.layout$default(subcomposeMeasureScope, tabRowWidth, accumulator$iv, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Placeable.PlacementScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope $this$layout) {
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                int i = i2;
                int index$iv = 0;
                for (Object item$iv : tabPlaceables) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, index$iv * i, 0, 0.0f, 4, (Object) null);
                    index$iv = index$iv2;
                }
                long j = j;
                int i2 = i3;
                for (Measurable it : subcomposeMeasureScope2.subcompose(TabSlots.Divider, function2)) {
                    Placeable placeable = it.m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null));
                    Measurable measurable = it;
                    Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, i2 - placeable.getHeight(), 0.0f, 4, (Object) null);
                    i2 = i2;
                    j = j;
                }
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                TabSlots tabSlots = TabSlots.Indicator;
                final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function3;
                final List<TabPosition> list = list;
                final int i3 = tabWidth2;
                int i4 = tabCount2;
                int i5 = i3;
                for (Measurable it2 : subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-976887453, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C179@8306L23:TabRow.kt#uh7d8r");
                        if (($changed & 11) != 2 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-976887453, $changed, -1, "androidx.compose.material3.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:178)");
                            }
                            function3.invoke(list, $composer, Integer.valueOf(((i3 >> 9) & 112) | 8));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer.skipToGroupEnd();
                    }
                }))) {
                    Placeable.PlacementScope.placeRelative$default($this$layout, it2.m4863measureBRTryo0(Constraints.Companion.m5938fixedJhjzzOo(i4, i5)), 0, 0, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
