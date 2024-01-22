package androidx.compose.material;

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
import java.util.Iterator;
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

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
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
        return m1665invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1665invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
        Object maxElem$iv;
        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int tabRowWidth = Constraints.m5930getMaxWidthimpl(constraints);
        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, this.$tabs);
        int tabCount = subcompose.size();
        int tabWidth = tabRowWidth / tabCount;
        Iterable<Measurable> $this$map$iv = subcompose;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Measurable it : $this$map$iv) {
            destination$iv$iv.add(it.m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, tabWidth, tabWidth, 0, 0, 12, (Object) null)));
            $this$map$iv = $this$map$iv;
        }
        List tabPlaceables = (List) destination$iv$iv;
        Iterator iterator$iv = tabPlaceables.iterator();
        if (!iterator$iv.hasNext()) {
            maxElem$iv = null;
        } else {
            maxElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                int maxValue$iv = ((Placeable) maxElem$iv).getHeight();
                while (true) {
                    Object e$iv = iterator$iv.next();
                    int v$iv = ((Placeable) e$iv).getHeight();
                    if (maxValue$iv < v$iv) {
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    }
                    if (!iterator$iv.hasNext()) {
                        break;
                    }
                    int i = tabCount;
                }
            }
        }
        Placeable placeable = (Placeable) maxElem$iv;
        final int tabRowHeight = placeable != null ? placeable.getHeight() : 0;
        ArrayList tabPositions = new ArrayList(tabCount);
        for (int index = 0; index < tabCount; index++) {
            tabPositions.add(new TabPosition(Dp.m5986constructorimpl(((float) index) * subcomposeMeasureScope.m5964toDpu2uoSUM(tabWidth)), subcomposeMeasureScope.m5964toDpu2uoSUM(tabWidth), (DefaultConstructorMarker) null));
        }
        final Function2<Composer, Integer, Unit> function2 = this.$divider;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        final int i2 = this.$$dirty;
        final List list = tabPlaceables;
        final SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
        final int i3 = tabWidth;
        final long j = constraints;
        final List list2 = tabPositions;
        final int i4 = tabRowWidth;
        int i5 = tabWidth;
        int i6 = tabCount;
        return MeasureScope.layout$default(subcomposeMeasureScope, tabRowWidth, tabRowHeight, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Placeable.PlacementScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope $this$layout) {
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                int i = i3;
                int index$iv = 0;
                for (Object item$iv : list) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, index$iv * i, 0, 0.0f, 4, (Object) null);
                    index$iv = index$iv2;
                }
                long j = j;
                int i2 = tabRowHeight;
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
                final List<TabPosition> list = list2;
                final int i3 = i2;
                int i4 = i4;
                int i5 = tabRowHeight;
                for (Measurable it2 : subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C176@8330L23:TabRow.kt#jmzs0o");
                        if (($changed & 11) != 2 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1341594997, $changed, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:175)");
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
