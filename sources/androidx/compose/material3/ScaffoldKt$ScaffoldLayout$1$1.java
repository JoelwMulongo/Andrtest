package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$ScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$ScaffoldLayout$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, int i2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$topBar = function2;
        this.$snackbar = function22;
        this.$fab = function23;
        this.$fabPosition = i;
        this.$contentWindowInsets = windowInsets;
        this.$bottomBar = function24;
        this.$$dirty = i2;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m2053invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m2053invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int layoutWidth = Constraints.m5930getMaxWidthimpl(constraints);
        int layoutHeight = Constraints.m5929getMaxHeightimpl(constraints);
        long looseConstraints = Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 10, (Object) null);
        final Function2<Composer, Integer, Unit> function2 = this.$topBar;
        final Function2<Composer, Integer, Unit> function22 = this.$snackbar;
        final Function2<Composer, Integer, Unit> function23 = this.$fab;
        final int i = this.$fabPosition;
        final WindowInsets windowInsets = this.$contentWindowInsets;
        final Function2<Composer, Integer, Unit> function24 = this.$bottomBar;
        final int i2 = this.$$dirty;
        final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
        final SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
        final int i3 = layoutWidth;
        final long j = looseConstraints;
        final int i4 = layoutHeight;
        return MeasureScope.layout$default(subcomposeMeasureScope, layoutWidth, layoutHeight, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Placeable.PlacementScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope $this$layout) {
                Object maxElem$iv;
                Object maxElem$iv2;
                Object maxElem$iv3;
                Integer num;
                FabPlacement fabPlacement;
                Object maxElem$iv4;
                Integer num2;
                int i;
                int i2;
                Object maxElem$iv5;
                Object maxElem$iv6;
                int fabLeftOffset;
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                Iterable<Measurable> $this$map$iv = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.TopBar, function2);
                long j = j;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Measurable it : $this$map$iv) {
                    destination$iv$iv.add(it.m4863measureBRTryo0(j));
                }
                Iterable<Placeable> topBarPlaceables = (List) destination$iv$iv;
                Iterator iterator$iv = topBarPlaceables.iterator();
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
                            Placeable.PlacementScope placementScope = $this$layout;
                        }
                    }
                }
                Placeable placeable = (Placeable) maxElem$iv;
                int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                Iterable<Measurable> $this$map$iv2 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                WindowInsets windowInsets = windowInsets;
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                long j2 = j;
                int $i$f$map = false;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Measurable it2 : $this$map$iv2) {
                    Density density = subcomposeMeasureScope;
                    Iterable $this$map$iv3 = $this$map$iv2;
                    int leftInset = windowInsets.getLeft(density, subcomposeMeasureScope.getLayoutDirection());
                    int i3 = leftInset;
                    destination$iv$iv2.add(it2.m4863measureBRTryo0(ConstraintsKt.m5946offsetNN6EwU(j2, (-leftInset) - windowInsets.getRight(density, subcomposeMeasureScope.getLayoutDirection()), -windowInsets.getBottom(density))));
                    $this$map$iv2 = $this$map$iv3;
                    $i$f$map = $i$f$map;
                    windowInsets = windowInsets;
                }
                int i4 = $i$f$map;
                Iterable<Placeable> $this$map$iv4 = (List) destination$iv$iv2;
                Iterator iterator$iv2 = $this$map$iv4.iterator();
                if (!iterator$iv2.hasNext()) {
                    maxElem$iv2 = null;
                } else {
                    maxElem$iv2 = iterator$iv2.next();
                    if (iterator$iv2.hasNext()) {
                        int maxValue$iv2 = ((Placeable) maxElem$iv2).getHeight();
                        while (true) {
                            Object e$iv2 = iterator$iv2.next();
                            int v$iv2 = ((Placeable) e$iv2).getHeight();
                            if (maxValue$iv2 < v$iv2) {
                                maxElem$iv2 = e$iv2;
                                maxValue$iv2 = v$iv2;
                            }
                            if (!iterator$iv2.hasNext()) {
                                break;
                            }
                            Placeable.PlacementScope placementScope2 = $this$layout;
                        }
                    }
                }
                Placeable placeable2 = (Placeable) maxElem$iv2;
                int snackbarHeight = placeable2 != null ? placeable2.getHeight() : 0;
                Iterator iterator$iv3 = $this$map$iv4.iterator();
                if (!iterator$iv3.hasNext()) {
                    maxElem$iv3 = null;
                } else {
                    maxElem$iv3 = iterator$iv3.next();
                    if (iterator$iv3.hasNext()) {
                        int maxValue$iv3 = ((Placeable) maxElem$iv3).getWidth();
                        while (true) {
                            Object e$iv3 = iterator$iv3.next();
                            int v$iv3 = ((Placeable) e$iv3).getWidth();
                            if (maxValue$iv3 < v$iv3) {
                                maxElem$iv3 = e$iv3;
                                maxValue$iv3 = v$iv3;
                            }
                            if (!iterator$iv3.hasNext()) {
                                break;
                            }
                            Object obj = maxElem$iv3;
                            Placeable.PlacementScope placementScope3 = $this$layout;
                        }
                    }
                }
                Placeable placeable3 = (Placeable) maxElem$iv3;
                int snackbarWidth = placeable3 != null ? placeable3.getWidth() : 0;
                Object it$iv$iv = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Fab, function23);
                WindowInsets windowInsets2 = windowInsets;
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope2;
                long j3 = j;
                int $i$f$mapNotNull = 0;
                Collection destination$iv$iv3 = new ArrayList();
                Object $this$mapNotNullTo$iv$iv = it$iv$iv;
                Iterator it3 = $this$mapNotNullTo$iv$iv.iterator();
                while (true) {
                    Object $this$mapNotNull$iv = it$iv$iv;
                    if (!it3.hasNext()) {
                        break;
                    }
                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                    Density density2 = subcomposeMeasureScope2;
                    Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                    WindowInsets windowInsets3 = windowInsets2;
                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope2;
                    Object it$iv$iv2 = ((Measurable) it3.next()).m4863measureBRTryo0(ConstraintsKt.m5946offsetNN6EwU(j3, (-windowInsets2.getLeft(density2, subcomposeMeasureScope2.getLayoutDirection())) - windowInsets2.getRight(density2, subcomposeMeasureScope2.getLayoutDirection()), -windowInsets2.getBottom(density2)));
                    Placeable it4 = it$iv$iv2;
                    if (!((it4.getHeight() == 0 || it4.getWidth() == 0) ? false : true)) {
                        it$iv$iv2 = null;
                    }
                    if (it$iv$iv2 != null) {
                        destination$iv$iv3.add(it$iv$iv2);
                        Placeable.PlacementScope placementScope4 = $this$layout;
                        it$iv$iv = $this$mapNotNull$iv;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        windowInsets2 = windowInsets3;
                        subcomposeMeasureScope2 = subcomposeMeasureScope3;
                    } else {
                        Placeable.PlacementScope placementScope5 = $this$layout;
                        it$iv$iv = $this$mapNotNull$iv;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        windowInsets2 = windowInsets3;
                        subcomposeMeasureScope2 = subcomposeMeasureScope3;
                    }
                }
                Iterable iterable = $this$mapNotNullTo$iv$iv;
                List<Placeable> fabPlaceables = (List) destination$iv$iv3;
                if (!fabPlaceables.isEmpty()) {
                    Iterator iterator$iv4 = fabPlaceables.iterator();
                    if (!iterator$iv4.hasNext()) {
                        maxElem$iv5 = null;
                    } else {
                        maxElem$iv5 = iterator$iv4.next();
                        if (iterator$iv4.hasNext()) {
                            int maxValue$iv4 = ((Placeable) maxElem$iv5).getWidth();
                            do {
                                Object e$iv4 = iterator$iv4.next();
                                int v$iv4 = ((Placeable) e$iv4).getWidth();
                                if (maxValue$iv4 < v$iv4) {
                                    maxElem$iv5 = e$iv4;
                                    maxValue$iv4 = v$iv4;
                                }
                            } while (iterator$iv4.hasNext());
                        }
                    }
                    Intrinsics.checkNotNull(maxElem$iv5);
                    int fabWidth = ((Placeable) maxElem$iv5).getWidth();
                    Iterator iterator$iv5 = fabPlaceables.iterator();
                    if (!iterator$iv5.hasNext()) {
                        maxElem$iv6 = null;
                    } else {
                        maxElem$iv6 = iterator$iv5.next();
                        if (iterator$iv5.hasNext()) {
                            int maxValue$iv5 = ((Placeable) maxElem$iv6).getHeight();
                            do {
                                Object e$iv5 = iterator$iv5.next();
                                int v$iv5 = ((Placeable) e$iv5).getHeight();
                                if (maxValue$iv5 < v$iv5) {
                                    maxElem$iv6 = e$iv5;
                                    maxValue$iv5 = v$iv5;
                                }
                            } while (iterator$iv5.hasNext());
                        }
                    }
                    Intrinsics.checkNotNull(maxElem$iv6);
                    int fabHeight = ((Placeable) maxElem$iv6).getHeight();
                    if (!FabPosition.m1925equalsimpl0(i, FabPosition.Companion.m1930getEndERTFSPs())) {
                        fabLeftOffset = (i3 - fabWidth) / 2;
                    } else if (subcomposeMeasureScope2.getLayoutDirection() == LayoutDirection.Ltr) {
                        fabLeftOffset = (i3 - subcomposeMeasureScope2.m5961roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth;
                    } else {
                        fabLeftOffset = subcomposeMeasureScope2.m5961roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    fabPlacement = new FabPlacement(fabLeftOffset, fabWidth, fabHeight);
                    num = null;
                } else {
                    num = null;
                    FabPlacement fabPlacement2 = null;
                    fabPlacement = null;
                }
                FabPlacement fabPlacement3 = fabPlacement;
                Iterable<Measurable> $this$map$iv5 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(-1455477816, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(fabPlacement3, function24, i2)));
                long j4 = j;
                Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                for (Measurable it5 : $this$map$iv5) {
                    destination$iv$iv4.add(it5.m4863measureBRTryo0(j4));
                }
                Iterable<Placeable> bottomBarPlaceables = (List) destination$iv$iv4;
                Iterator iterator$iv6 = bottomBarPlaceables.iterator();
                if (!iterator$iv6.hasNext()) {
                    maxElem$iv4 = num;
                } else {
                    maxElem$iv4 = iterator$iv6.next();
                    if (iterator$iv6.hasNext()) {
                        int maxValue$iv6 = ((Placeable) maxElem$iv4).getHeight();
                        while (true) {
                            Object e$iv6 = iterator$iv6.next();
                            int v$iv6 = ((Placeable) e$iv6).getHeight();
                            if (maxValue$iv6 < v$iv6) {
                                maxElem$iv4 = e$iv6;
                                maxValue$iv6 = v$iv6;
                            }
                            if (!iterator$iv6.hasNext()) {
                                break;
                            }
                        }
                    }
                }
                Placeable placeable4 = (Placeable) maxElem$iv4;
                Integer bottomBarHeight = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : num;
                if (fabPlacement3 != null) {
                    SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope2;
                    WindowInsets windowInsets4 = windowInsets;
                    FabPlacement it6 = fabPlacement3;
                    if (bottomBarHeight == null) {
                        i2 = it6.getHeight() + subcomposeMeasureScope4.m5961roundToPx0680j_4(ScaffoldKt.FabSpacing) + windowInsets4.getBottom(subcomposeMeasureScope4);
                    } else {
                        i2 = bottomBarHeight.intValue() + it6.getHeight() + subcomposeMeasureScope4.m5961roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    num2 = Integer.valueOf(i2);
                } else {
                    num2 = num;
                }
                Integer fabOffsetFromBottom = num2;
                if (snackbarHeight != 0) {
                    i = snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight != null ? bottomBarHeight.intValue() : windowInsets.getBottom(subcomposeMeasureScope2));
                } else {
                    i = 0;
                }
                int snackbarOffsetFromBottom = i;
                Iterable<Measurable> $this$map$iv6 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(1643221465, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(windowInsets, subcomposeMeasureScope2, topBarPlaceables, topBarHeight, bottomBarPlaceables, bottomBarHeight, function3, i2)));
                long j5 = j;
                Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                for (Measurable it7 : $this$map$iv6) {
                    destination$iv$iv5.add(it7.m4863measureBRTryo0(j5));
                }
                for (Placeable it8 : (List) destination$iv$iv5) {
                    Placeable.PlacementScope.place$default($this$layout, it8, 0, 0, 0.0f, 4, (Object) null);
                    fabPlacement3 = fabPlacement3;
                }
                FabPlacement fabPlacement4 = fabPlacement3;
                for (Placeable it9 : topBarPlaceables) {
                    Placeable.PlacementScope.place$default($this$layout, it9, 0, 0, 0.0f, 4, (Object) null);
                }
                int i5 = i3;
                WindowInsets windowInsets5 = windowInsets;
                SubcomposeMeasureScope subcomposeMeasureScope5 = subcomposeMeasureScope2;
                int i6 = i4;
                for (Placeable place$default : $this$map$iv4) {
                    Placeable.PlacementScope.place$default($this$layout, place$default, ((i5 - snackbarWidth) / 2) + windowInsets5.getLeft(subcomposeMeasureScope5, subcomposeMeasureScope5.getLayoutDirection()), i6 - snackbarOffsetFromBottom, 0.0f, 4, (Object) null);
                    i6 = i6;
                }
                int i7 = i4;
                for (Placeable it10 : bottomBarPlaceables) {
                    Placeable.PlacementScope.place$default($this$layout, it10, 0, i7 - (bottomBarHeight != null ? bottomBarHeight.intValue() : 0), 0.0f, 4, (Object) null);
                }
                if (fabPlacement4 != null) {
                    int i8 = i4;
                    FabPlacement placement = fabPlacement4;
                    for (Placeable it11 : fabPlaceables) {
                        int left = placement.getLeft();
                        Intrinsics.checkNotNull(fabOffsetFromBottom);
                        Placeable.PlacementScope.place$default($this$layout, it11, left, i8 - fabOffsetFromBottom.intValue(), 0.0f, 4, (Object) null);
                    }
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }, 4, (Object) null);
    }
}
